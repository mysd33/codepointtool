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
        return List.of(
                // TODO: 必要に応じて追加・修正してください
                // JIS X 0213で追加された非漢字の特殊ひらがな
                new TargetData("JIS_X_0213_SpecialHiragana", "JIS X 0213の特殊ひらがな（1面4区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "04".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊カタカナ
                new TargetData("JIS_X_0213_SpecialKatakana", "JIS X 0213の特殊カタカナ（1面5区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen()) && "05".equals(jisCharacter.getKu())
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                // JIS X 0213で追加された非漢字の特殊文字、記号
                new TargetData("JIS_X_0213_AddedSymbol",
                        "JIS X 0213で追加された各種記号（1面2-3区、6-7区、8区）、西欧系各種文字・記号（1面9-11区）、各種数字記号（12-13区）の文字集合を表すクラス",
                        jisCharacter -> "01".equals(jisCharacter.getMen())
                                && ("02".equals(jisCharacter.getKu()) || "03".equals(jisCharacter.getKu())
                                        || "06".equals(jisCharacter.getKu()) || "07".equals(jisCharacter.getKu())
                                        || "08".equals(jisCharacter.getKu()) || "09".equals(jisCharacter.getKu())
                                        || "10".equals(jisCharacter.getKu()) || "11".equals(jisCharacter.getKu())
                                        || "12".equals(jisCharacter.getKu()) || "13".equals(jisCharacter.getKu()))
                                && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun()))

        );
    }
}
