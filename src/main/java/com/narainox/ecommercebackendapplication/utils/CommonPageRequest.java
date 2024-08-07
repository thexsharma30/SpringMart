package com.narainox.ecommercebackendapplication.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonPageRequest {
    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String sortDir;
}
