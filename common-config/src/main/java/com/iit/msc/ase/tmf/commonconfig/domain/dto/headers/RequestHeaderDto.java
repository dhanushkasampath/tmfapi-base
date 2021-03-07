package com.iit.msc.ase.tmf.commonconfig.domain.dto.headers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class RequestHeaderDto {

    @NotNull( message = "requestId cannot be null" )
    @NotEmpty( message = "requestId cannot be empty" )
    private String requestId;

    @NotNull( message = "timestamp cannot be null" )
    @NotEmpty( message = "timestamp cannot be empty" )
    private String timestamp;

    @NotNull( message = "channel cannot be null" )
    @NotEmpty( message = "channel cannot be empty" )
    private String channel;

}
