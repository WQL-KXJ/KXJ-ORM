package com.wqlkxj.core.wrapper;

import com.wqlkxj.core.segmentlist.Compare;
import com.wqlkxj.core.segmentlist.MergeSegments;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.core.wrapper
 * @Date 2022/6/11 17:55
 * @Version 1.0
 */
public abstract class AbstractWrapper<T,R,Iself extends AbstractWrapper<T,R,Iself>> implements Compare<Iself,R> {

        protected final Iself iselfthis = (Iself) this;

        protected MergeSegments mergeSegments;

        public abstract Iself eq(R column, Object value);


}
