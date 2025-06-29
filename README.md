# コードポイントクラス自動生成ツール

- [国税庁さまのサイト](https://www.houjin-bangou.nta.go.jp/download/index.html)に著作物[JIS 縮退マップ](https://www.houjin-bangou.nta.go.jp/pc/download/images/jissyukutaimap1_0_0.xlsx)を用いて、JIS X 0213で追加になった非漢字部分のCodePointsクラスを自動生成するツールです。
    - CodePointsクラスは、[TERASOLUNA Server Frameworkのコードポイント集合チェック機能](https://terasolunaorg.github.io/guideline/current/ja/ArchitectureInDetail/GeneralFuncDetail/StringProcessing.html#stringprocessinghowtousecodepoints)をもとにしたクラスです。

- 使い方
    - [Main](src/main/java/codepointtool/Main.java)クラスを実行します
    - generated/src/main/javaフォルダに、CodePointsクラスのjavaファイルが生成されます。
        - この例では、JIS X 0213で追加された非漢字を対象としたCodePoinsクラスが生成されます。
    - 自分で、必要なコードポイント集合を作りたい場合は、[TargetDataCreator](src/main/java/codepointtool/TargetDataCreator.java)のgetTargetDateListメソッドを修正します。
    - [TargetData](src/main/java/codepointtool/TargetData.java)のコンストラクタ（またはBuilder）で、以下を指定します。
        - 生成するクラス名
        - 生成するクラスの説明（javadocコメントに使用）
        - JIS縮退マップのExcelファイルの値から文字を抽出する条件（面、区やJIS区分等）

    ```java
    public class TargetDataCreator {

        public List<TargetData> getTargetDataList() {
            return List.of(
                    // TODO: 必要に応じて追加・修正してください

                    // JIS X 0213で追加された非漢字の特殊ひらがなの例
                    new TargetData("JIS_X_0213_SpecialHiragana", "特殊ひらがな（1面4区）の文字集合を表すクラス",
                            jisCharacter -> "01".equals(jisCharacter.getMen()) && "04".equals(jisCharacter.getKu())
                                    && JISCharacter.JIS_ADDED_NOT_KANJI.equals(jisCharacter.getKubun())),
                    …
            );
        }
    }
    ```