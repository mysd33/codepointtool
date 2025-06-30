package codepointtool;

import java.util.List;

import codepointtool.model.JISCharacter;

/**
 * JIS縮退マップのExcelファイルから自動生成対象のコードポイントクラスの情報を作成するクラス
 * 
 */
public class TargetDataCreator {
    /**
     * 自動生成対象のコードポイントクラスの情報を保持するリストを取得する。
     * 
     * @return 自動生成対象のコードポイントクラスの情報を保持するリスト
     */
    public List<TargetData> getTargetDataList() {
        // JIS X 0213非漢字一覧
        // https://ja.wikipedia.org/wiki/JIS_X_0213%E9%9D%9E%E6%BC%A2%E5%AD%97%E4%B8%80%E8%A6%A7
        return List.of(
                // TODO: 必要に応じて追加・修正してください
                // 特殊文字のうち全角文字（記号なし）チェックに含めたいもの
                new TargetData("CustomFullWidthCharSet", "特殊文字扱いでも全角文字（記号なし）チェックに含める文字集合を表すクラス", jisCharacter -> {
                    String menkuTen = jisCharacter.getMen() + "-" + jisCharacter.getKu() + "-" + jisCharacter.getTen();
                    // 以下の面-区-点がいずれかの文字を含む
                    return "01-01-25".equals(menkuTen) || // 々 (01-01-25)
                            "01-01-26".equals(menkuTen) || // 〆 (01-01-26)
                            "01-01-28".equals(menkuTen) || // ー(01-01-28)
                            "01-06-78".equals(menkuTen) || // ㇰ(01-06-78)
                            "01-06-79".equals(menkuTen) || // ㇱ(01-06-79)
                            "01-06-80".equals(menkuTen) || // ㇲ(01-06-80)
                            "01-06-81".equals(menkuTen) || // ㇳ(01-06-81)
                            "01-06-82".equals(menkuTen) || // ㇴ(01-06-82)
                            "01-06-83".equals(menkuTen) || // ㇵ(01-06-83)
                            "01-06-84".equals(menkuTen) || // ㇶ(01-06-84)
                            "01-06-85".equals(menkuTen) || // ㇷ(01-06-85)
                            "01-06-86".equals(menkuTen) || // ㇸ(01-06-86)
                            "01-06-87".equals(menkuTen) || // ㇹ(01-06-87)
                            "01-06-88".equals(menkuTen) || // ㇷ゚(01-06-88) 合成文字
                            "01-06-89".equals(menkuTen) || // ㇺ(01-06-89)
                            "01-06-90".equals(menkuTen) || // ㇻ(01-06-90)
                            "01-06-91".equals(menkuTen) || // ㇼ(01-06-91)
                            "01-06-92".equals(menkuTen) || // ㇽ(01-06-92)
                            "01-06-93".equals(menkuTen) || // ㇾ(01-06-93)
                            "01-06-94".equals(menkuTen) || // ㇿ(01-06-94)
                            "01-07-82".equals(menkuTen) || // ヷ(01-07-82)
                            "01-07-83".equals(menkuTen) || // ヸ(01-07-83)
                            "01-07-84".equals(menkuTen) || // ヹ(01-07-84)
                            "01-07-85".equals(menkuTen); // ヺ(01-07-85)
                }),
                // JIS X 0213で追加された非漢字の特殊ひらがな（1面4区）
                new TargetData("JIS_X_0213_4ku_AddedSpecialHiragana", "JIS X 0213の追加非漢字の特殊ひらがな（1面4区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "04".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊カタカナ（1面5区）
                new TargetData("JIS_X_0213_5ku_AddedSpecialKatakana", "JIS X 0213の追加非漢字の特殊カタカナ（1面5区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "05".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊文字、カタカナ（1面6区）
                new TargetData("JIS_X_0213_6ku_AddedSpecialCharsKatakana",
                        "JIS X 0213の追加非漢字の特殊文字、特殊カタカナ（1面6区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "06".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊文字カタカナ（1面7区）
                new TargetData("JIS_X_0213_7ku_AddedSpecialCharsKatakana",
                        "JIS X 0213の追加非漢字の特殊文字、特殊カタカナ（1面7区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "07".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊文字、記号（1面8区）
                new TargetData("JIS_X_0213_8ku_AddedSpecialChars", "JIS X 0213の追加非漢字の特殊文字、記号（1面8区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "08".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊文字、記号（1面9-11区）
                new TargetData("JIS_X_0213_9_11ku_AddedSpecialChars", "JIS X 0213の追加非漢字の特殊文字、記号（1面9～11区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen())
                                && ("09".equals(jisCharacter.getKu()) || "10".equals(jisCharacter.getKu())
                                        || "11".equals(jisCharacter.getKu()))
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊文字、記号（1面12-13区）
                new TargetData("JIS_X_0213_12_13ku_AddedSpecialChars", "JIS X 0213の特殊文字、記号（1面12～13区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen())
                                && ("12".equals(jisCharacter.getKu()) || "13".equals(jisCharacter.getKu()))
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())));
    }
}
