package com.spring.springboot.page;


import org.apache.commons.lang3.StringUtils;

/**
 * PageState （标识页面状态）
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public enum PageState {
    /** 设置每页显示多少条 */
    SETPAGE,
    /** 首页 */
    FIRST,
    /** 向前一页 */
    PREVIOUS,
    /** 向后一页 */
    NEXT,
    /** 最后一页 */
    LAST,
    /** 排序 */
    SORT,
    /** 到第多少页 */
    GOPAGE;

    /**
     * 返回指定索引名称的下标
     *
     * @param value 索引名称
     * @return 返回索引下标
     */
    public static int getOrdinal(String value) {
        int index = -1;
        if (StringUtils.isEmpty(value)) {
            return index;
        }
        String newValue = StringUtils.trim(value).toUpperCase();
        try {
            index = valueOf(newValue).ordinal();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return index;
    }

}
