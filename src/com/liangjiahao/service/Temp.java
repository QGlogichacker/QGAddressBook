package com.liangjiahao.service;

import com.liangjiahao.model.Member;

public class Temp {
    private Member mem;
    public static final String exp = "1，%：表示任意0个或多个字符。可匹配任意类型和长度的字符，有些情况下若是中文，请使用两个百分号（%%）表示。\n将会把u_name为“张三”，“张猫三”、“三脚猫”，“唐三藏”等等有“三”的记录全找出来。 \n2，_： 表示任意单个字符。匹配单个任意字符，它常用来限制表达式的字符长度语句： \n只找出“唐三藏”这样u_name为三个字且中间一个字是“三”的； \n3，[ ]：表示括号内所列字符中的一个（类似正则表达式）。指定一个字符、字符串或范围，要求所匹配对象为它们中的任一个。\n[ ] 内有一系列字符（01234、abcde之类的）则可略写为“0-4”、“a-e” \n如老[1-9' 将找出老1、老2、……、老9； \n4，[^ ] ：表示不在括号所列之内的单个字符。其取值和 [] 相同，但它要求所匹配对象为指定字符以外的任一个字符。 \n比如 [^张李王]三'将找出不姓“张”、“李”、“王”的“赵三”、“孙三”等； \n也可以用上面的省略法\n5，查询内容包含通配符时 \n由于通配符的缘故，导致我们查询特殊字符“%”、“_”、“[”的语句无法正常实现，而把特殊字符用“[ ]”括起便可正常查询。";
    public static final String exp2 = "本输入将跳过所有空行或者第一列为空的行，\n并将每行前8个数据分别作为姓名,方向,年级,班级,电话,邮箱,宿舍,地址";

    public Temp() {
    }

    public Member getMem() {
        return this.mem;
    }

    public void setMem(Member mem) {
        this.mem = mem;
    }
}
