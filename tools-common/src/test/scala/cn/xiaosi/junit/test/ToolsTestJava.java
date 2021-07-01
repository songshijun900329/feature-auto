package cn.xiaosi.junit.test;

import cn.xiaosi.junit.test.beans.Field;
import cn.xiaosi.tool.common.utils.Builder;
import org.junit.jupiter.api.Test;

public class ToolsTestJava {


    @Test
    public void testBuilder() {

        Field testField001 = Builder.of(Field::new)
                .with(Field::setBeAnalyzed, false)
                .with(Field::setBeMerge,false)
                .with(Field::setBeMultiValue,false)
                .with(Field::setBeNotNull,true)
                .with(Field::setBeQueried,true)
                .with(Field::setCHName,"采集地")
                .with(Field::setCodeSet,"")
                .with(Field::setDescription,"")
                .with(Field::setENName,"COLLECT_PLACE")
                .with(Field::setElementID,"F010008")
                .with(Field::setSeqNumber,1)
                .with(Field::setValueDefault,"")
                .with(Field::setValueLength,6)
                .with(Field::setValueType,"string")
                .build();

        System.out.println(testField001.toString());

    }

}
