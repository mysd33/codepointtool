package codepointtool;

import java.io.IOException;
import java.util.List;

import codepointtool.formatter.CodePointsClassCodeFormatter;
import codepointtool.model.CodePointsClassModel;
import codepointtool.model.JISCharacter;
import codepointtool.parser.JISSyukutaiMapParser;

/**
 * ツールのメインクラス
 */
public class Main {
    // JIS縮退マップのExcelファイル名
    private static final String JIS_SYKUTAI_MAP_FILEPATH = "input/jissyukutaimap1_0_0.xlsx";
    // 出力するコードポイントクラスのパッケージ名
    private static final String CODE_POINTS_CLASS_PACKAGE = "com.example.fw.common.codepoints";

    /**
     * メインメソッド
     */
    public static void main(String[] args) throws IOException {
        // パーサーのインスタンスを作成
        JISSyukutaiMapParser parser = new JISSyukutaiMapParser(JIS_SYKUTAI_MAP_FILEPATH);
        // フォーマッタのインスタンスを作成
        CodePointsClassCodeFormatter formatter = new CodePointsClassCodeFormatter();
        // 各ターゲットデータに対してコードポイントクラスを生成
        List<TargetData> targetDataList = new TargetDataCreator().getTargetDataList();
        for (TargetData targetData : targetDataList) {
            List<JISCharacter> characters = parser.parse(targetData.getTargetFilter());
            CodePointsClassModel codePointsClassModel = CodePointsClassModel.builder()
                    .packageName(CODE_POINTS_CLASS_PACKAGE).className(targetData.getClassName())
                    .description(targetData.getDescription()).characters(characters).build();
            // コードポイントクラスのコードを生成
            formatter.format(codePointsClassModel);
        }

    }

}
