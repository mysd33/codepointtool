package com.example.fw.common.codepoints;

import org.terasoluna.gfw.common.codepoints.CodePoints;

/**
 *  特殊ひらがな（1面4区）の文字集合を表すクラス
 */
public final class JIS_X_0213_SpecialHiragana extends CodePoints {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public JIS_X_0213_SpecialHiragana() {
	        super(t0(new Integer[7]));
    }

    private static Integer[] t0(Integer[] cp) {
        cp[0] = 0x3094; // ゔ(01-04-84) 
        cp[1] = 0x3095; // ゕ(01-04-85) 
        cp[2] = 0x3096; // ゖ(01-04-86) 
        cp[3] = 0x304B; // か゚(01-04-87) 
        cp[4] = 0x309A; // か゚(01-04-87) 
        cp[5] = 0x304D; // き゚(01-04-88) 
        cp[6] = 0x309A; // き゚(01-04-88) 
        cp[7] = 0x304F; // く゚(01-04-89) 
        cp[8] = 0x309A; // く゚(01-04-89) 
        cp[9] = 0x3051; // け゚(01-04-90) 
        cp[10] = 0x309A; // け゚(01-04-90) 
        cp[11] = 0x3053; // こ゚(01-04-91) 
        cp[12] = 0x309A; // こ゚(01-04-91) 
        return cp;
    }
}   