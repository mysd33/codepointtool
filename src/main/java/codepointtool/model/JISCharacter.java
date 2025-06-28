package codepointtool.model;

import lombok.Builder;
import lombok.Value;

/**
 * JISコードの文字を表すクラス
 */
@Value
@Builder
public class JISCharacter {
    public static final String JIS_1_SUI = "JIS1水";
    public static final String JIS_2_SUI = "JIS2水";
    public static final String JIS_3_SUI = "JIS3水";
    public static final String JIS_4_SUI = "JIS4水";
    public static final String JIS_NOT_KANJI = "非漢字";
    public static final String JIS_ADDED_NOT_KANJI = "追加非漢字";

    // JIS面
    private final String men;
    // JIS区
    private final String ku;
    // JIS点
    private final String ten;
    // Unicodeコードポイント（合成文字がある場合は複数要素）
    private final String[] codePoints;
    // 字形（実際の文字）
    private final String glyph;
    // JIS区分(JIS1水, JIS2水, JIS3水, JIS4水, 非漢字, 追加非漢字)
    private final String kubun;

}
