package com.spring.springboot.springbootswagger2.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * customer_group
 *
 * @author
 */
@ApiModel(value = "customerGroupFrom", description="用户小组描述")
@Data
public class CustomerGroupFrom implements Serializable {
    private static final long serialVersionUID = -2400202575820109852L;
    /**
     * 主键id
     */
    @ApiModelProperty(name = "小组id", value = "1", hidden = true)
    private Integer id;

    /**
     * 门店id
     */
    @ApiModelProperty(name = "门店id", value = "1", required = true)
    private Integer storeId;

    /**
     * 小组名称
     */
    @ApiModelProperty(name = "小组名称", value = "登风小组", required = true)
    private String groupName;

    /**
     * 标记组长
     */
    @ApiModelProperty(name = "组长的id信息", value = "1234", required = true)
    private Integer backUserId;

    /**
     * 小组成员id
     */
    @ApiModelProperty(name = "小组成员id", value = "1234", required = true)
    private List<Integer> memberIdList;
}