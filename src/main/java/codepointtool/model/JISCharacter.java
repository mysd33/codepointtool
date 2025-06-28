package codepointtool.model;


import lombok.Builder;
import lombok.Value;

/**
 * JISコードの文字を表すクラス
 */
@Value
@Builder
public class JISCharacter {
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
    
}
