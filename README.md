# コードポイントクラス自動生成ツール

- 国税庁の著作物[JIS 縮退マップ](https://www.houjin-bangou.nta.go.jp/download/index.html)を用いて、JIS X 0213で追加になった非漢字部分のCodePointsクラスを自動生成するツールです。
    - CodePointsクラスは、[TERASOLUNA Server Frameworkのコードポイント集合チェック機能](https://terasolunaorg.github.io/guideline/current/ja/ArchitectureInDetail/GeneralFuncDetail/StringProcessing.html#stringprocessinghowtousecodepoints)をもとにしたクラスです。

- 使い方
    - Mainクラスを実行します
    - generated/src/main/javaフォルダに、CodePointsクラスのjavaファイルが生成されます。