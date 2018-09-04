package club.mator.sum.jvm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created: 上午11:59-2018/7/25
 * author: feiFei.chen
 * desc: 应用实体
 * version: 1.0
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EntryJvm implements Serializable {


    private String name;
}
