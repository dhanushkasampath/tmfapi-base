package com.iit.msc.ase.tmf.commonconfig.domain.dto.headers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHeaderDto {

    private String requestId;
    private String timestamp;
    private String responseCode;
    private String responseDesc;
    private String responseDescDisplay;

}
