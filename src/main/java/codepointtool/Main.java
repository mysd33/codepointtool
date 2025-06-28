package codepointtool;

import java.io.IOException;
import java.util.List;

import codepointtool.formatter.CodePointsClassCodeFormatter;
import codepointtool.model.CodePointsClassModel;
import codepointtool.model.JISCharacter;
import codepointtool.parser.JISSyukutaiMapParser;

public class Main {
    // JIS縮退マップのExcelファイル名
    private static final String JIS_SYKUTAI_MAP_FILEPATH = "input/jissyukutaimap1_0_0.xlsx";
    // 出力するコードポイントクラスのパッケージ名
    private static final String CODE_POINTS_CLASS_PACKAGE = "com.example.fw.common.codepoints";

    public static void main(String[] args) throws IOException {
        // パーサーのインスタンスを作成
        JISSyukutaiMapParser parser = new JISSyukutaiMapParser(JIS_SYKUTAI_MAP_FILEPATH);
        // フォーマッタのインスタンスを作成
        CodePointsClassCodeFormatter formatter = new CodePointsClassCodeFormatter();
        // 各ターゲットデータに対してコードポイントクラスを生成
        List<TargetData> targetDataList = getTargetDataList();
        for (TargetData targetData : targetDataList) {
            List<JISCharacter> characters = parser.parse(targetData.getTargetFilter());
            CodePointsClassModel codePointsClassModel = CodePointsClassModel.builder()
                    .packageName(CODE_POINTS_CLASS_PACKAGE).className(targetData.getClassName())
                    .description(targetData.getDescription()).characters(characters).build();
            // コードポイントクラスのコードを生成
            formatter.format(codePointsClassModel);
        }

    }

    /**
     * 自動生成対象のコードポイントクラスの情報を保持するリストを取得する。
     * 
     * @return 自動生成対象のコードポイントクラスの情報を保持するリスト
     */
    private static List<TargetData> getTargetDataList() {
        return List.of(//
                new TargetData("JIS_X_0213_SpecialHiragana", "特殊ひらがな（1面4区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "04".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                new TargetData("JIS_X_0213_SpecialKatakana", "特殊カタカナ（1面5区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "05".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                new TargetData("JIS_X_0213_AddedSymbol",
                        "各種記号（1面2-3区、6-7区、8区）西欧系各種文字・記号（1面9-11区）、各種数字記号（12-13区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen())
                                && ("02".equals(jisCharacter.getKu()) || "03".equals(jisCharacter.getKu())
                                        || "06".equals(jisCharacter.getKu()) || "07".equals(jisCharacter.getKu())
                                        || "08".equals(jisCharacter.getKu()) || "09".equals(jisCharacter.getKu())
                                        || "10".equals(jisCharacter.getKu()) || "11".equals(jisCharacter.getKu())
                                        || "12".equals(jisCharacter.getKu()) || "13".equals(jisCharacter.getKu()))
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())));
    }
}
