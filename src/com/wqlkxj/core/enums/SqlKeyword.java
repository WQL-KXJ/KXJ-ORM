package com.wqlkxj.core.enums;

import com.wqlkxj.core.segmentlist.MySqlSegment;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.core.enums
 * @Date 2022/6/8 12:59
 * @Version 1.0
 */
public enum SqlKeyword implements MySqlSegment {

    EQ("="),
    GT(">"),
    GE(">="),
    LT("<"),
    LE("<="),
    AND("AND"),
    IN("IN"),
    LIKE("LIKE"),
    BETWEEN("BETWEEN"),
    OR("OR"),
    NOT("NOT"),
    NOT_IN("NOT IN"),
    IS_NULL("IS NULL"),
    IS_NOT_NULL("IS NOT NULL");

    private final String wordkey;

    private SqlKeyword(final String wordkey) {
        this.wordkey = wordkey;
    }

    @Override //返回当前对象的wordkey值
    public String getSqlSegment() {
        return this.wordkey;
    }
}

