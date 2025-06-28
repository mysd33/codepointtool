package codepointtool.formater;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import codepointtool.model.JISCharacter;
import lombok.extern.slf4j.Slf4j;

/**
 * JIS縮退マップのExcelファイルをパースするクラス
 */
@Slf4j
public class JISSyukutaiMapParser {
    // JIS縮退マップのExcelファイル名
    private static final String JIS_SYKUTAI_MAP_FILE = "jissyukutaimap1_0_0.xlsx";
    // シート名「JIS縮退マップ」
    private static final String SHEET_NAME = "JIS縮退マップ";
    // 1列目A列にある面句点コード(面-区-点)のインデックス
    private static final int MEN_KU_TEN_INDEX = 0;
    // 2列目B列にあるUnicodeコードポイントのインデックス
    private static final int UNICODE_CODEPOINT_INDEX = 1;
    // 3列目C列にある字形のインデックス
    private static final int GLYPH_INDEX = 2;
    // ヘッダー行数
    private static final int HEADER_ROW_COUNT = 2;

    /**
     * JIS縮退マップのExcelファイルをパースして、指定された条件に合致するJISCharacterのリストを返す。
     * 
     * @param targetFilter 指定された条件
     * @return 条件に合致するJISCharacterのリスト
     * @throws IOException
     * @throws Exception
     */
    public List<JISCharacter> parse(TargetFilter targetFilter) throws IOException {
        final List<JISCharacter> jisCharacters = new ArrayList<>();
        // Apache PoiでExcelファイルを読み込む
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(JIS_SYKUTAI_MAP_FILE)) {
            try (Workbook workbook = new XSSFWorkbook(is)) {
                // 最初のシートシートを読み込み、JISCharacterのリストを作成する
                Sheet sheet = workbook.getSheet(SHEET_NAME);
                // 1行ずつ読み込み文字の情報を取得する
                for (Row row : sheet) {
                    if (row.getRowNum() < HEADER_ROW_COUNT) {
                        // ヘッダー行はスキップ
                        continue;
                    }
                    JISCharacter jisCharacter = createJISCharacter(row);
                    if (jisCharacter == null) {
                        //面句点コードが空のセルがあったところで終了
                        break;
                    }
                    if (targetFilter.isTarget(jisCharacter)) {
                        jisCharacters.add(jisCharacter);
                    }
                }
            }
        }
        return jisCharacters;
    }

    // 各セルの情報をもとに1文字分のJISCharacterを生成する
    private JISCharacter createJISCharacter(Row row) {
        try {
            Cell menKuTenCell = row.getCell(MEN_KU_TEN_INDEX);
            Cell unicodeCodePointCell = row.getCell(UNICODE_CODEPOINT_INDEX);
            Cell glyphCell = row.getCell(GLYPH_INDEX);
            // 面-区-点の文字列を取得
            String menKuTenCellString =  menKuTenCell.getStringCellValue();
            if (menKuTenCellString == null || menKuTenCellString.isEmpty()) {
                log.warn("{}行目の面-区-点コードが空です。スキップします。", row.getRowNum() + 1);
                return null; // 空のセルはスキップ
            }
            // 「-」で分割
            String[] menKuTenParts = menKuTenCellString.split("-");
            // Unicodeコードポイントの文字列を、合成文字で複数コードポイントあるケースを考慮し半角スペースで分割
            String[] codePoints = unicodeCodePointCell.getStringCellValue().split(" ");
            // 字形の文字列を取得
            String glyph = glyphCell.getStringCellValue();
            log.debug("行番号: {}", row.getRowNum() + 1);
            log.debug("面-区-点: {}-{}-{}", menKuTenParts[0], menKuTenParts[1], menKuTenParts[2]);
            log.debug("Unicodeコードポイント: {}", String.join(", ", codePoints));
            log.debug("字形: {}", glyph);
            return JISCharacter.builder().men(menKuTenParts[0]) // 面
                    .ku(menKuTenParts[1]) // 区
                    .ten(menKuTenParts[2]) // 点
                    .codePoints(codePoints) // Unicodeコードポイント
                    .glyph(glyph) // 字形
                    .build();
        } catch (RuntimeException e) {
            log.error("{}行目で、想定外のエラーが発生", row.getRowNum() + 1, e.getMessage());
            throw e;
        }
    }
}
