
package com.littlefox.area.model;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * 地区
 * @author rockychen
 */
public class Area {
    /**
     * code
     */
    private String code;

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 层级
     */
    private String level;
}
