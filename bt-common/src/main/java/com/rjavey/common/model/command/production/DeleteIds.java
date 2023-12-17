package com.rjavey.common.model.command.production;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author rjavey
 */
@Data
public class DeleteIds {

    @NotEmpty(message = "参数不可为空")
    private List<Long> ids;
}
