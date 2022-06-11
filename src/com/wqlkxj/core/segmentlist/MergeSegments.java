package com.wqlkxj.core.segmentlist;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.core.segmentlist
 * @Date 2022/6/11 17:16
 * @Version 1.0
 */
public class MergeSegments implements MySqlSegment {

    private final NormalSegmentList normalSegmentList = new NormalSegmentList();

    @Override
    public String getSqlSegment() {
        return null;
    }
}
