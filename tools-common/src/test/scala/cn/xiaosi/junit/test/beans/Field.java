package cn.xiaosi.junit.test.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/*
    XmlAccessType.FIELD：映射这个类中的所有字段到XML
    XmlAccessType.PROPERTY：映射这个类中的属性（get/set方法）到XML
    XmlAccessType.PUBLIC_MEMBER：将这个类中的所有public的field或property同时映射到XML（默认）
    XmlAccessType.NONE：不映射
 */
@XmlAccessorType(XmlAccessType.FIELD)
/**
 *
 JAXB 转换对象必须属于JAXBElement类型，或者使用 @XmlRootElement注解
 JAXB 转换对象必须拥有无参数构造器（默认存在，如果被覆盖，需要显示指定）
 */
@XmlRootElement // 类级别的注解。将类映射为xml全局元素，也就是根元素。如果要使用 JAXB ，则该注解必不可少
public final class Field {

    /**
     * 是否分析
     */
    @XmlAttribute(name = "BeAnalyzed")
    private Boolean BeAnalyzed;

    /**
     * 是否合并
     */
    @XmlAttribute(name = "BeMerge")
    private Boolean BeMerge;

    /**
     * 是否多值
     */
    @XmlAttribute(name = "BeMultiValue")
    private Boolean BeMultiValue;

    /**
     * 是否允许为空
     */
    @XmlAttribute(name = "BeNotNull")
    private Boolean BeNotNull;

    /**
     * 是否查询字段
     */
    @XmlAttribute(name = "BeQueried")
    private Boolean BeQueried;

    /**
     * 字段中文名称
     */
    @XmlAttribute(name = "CHName")
    private String CHName;

    /**
     * 字段对应字典代码集
     * eg:
     * <CodeSetFile Description="案中地位代码表" Name="RUN_ESCODE_0235">
     * 	<CodeSet AliasCHName="" AliasCSID="" AliasENName="" CHName="案中地位代码表" CSID="RUN_ESCODE_0235" Description="" ENName="RUN_ESCODE_0235">
     * 		<Item Code="30" Description="" Name="协犯" Type=""/>
     * 		<Item Code="20" Description="" Name="从犯" Type=""/>
     * 		<Item Code="10" Description="" Name="主犯" Type=""/>
     * 		<Item Code="99" Name="其他" Type="" Description=""/>
     * 	</CodeSet>
     * </CodeSetFile>
     */
    @XmlAttribute(name = "CodeSet")
    private String CodeSet;

    /**
     * 字段描述
     */
    @XmlAttribute(name = "Description")
    private String Description;

    /**
     * 字段英文名称
     */
    @XmlAttribute(name = "ENName")
    private String ENName;

    /**
     * 对应元素ID
     */
    @XmlAttribute(name = "ElementID")
    private String ElementID;

    /**
     * 字段序列化序号「protobuf」
     */
    @XmlAttribute(name = "SeqNumber")
    private Integer SeqNumber;

    /**
     * 字段默认值
     */
    @XmlAttribute(name = "ValueDefault")
    private String ValueDefault;

    /**
     * 字段值长度「protobuf」
     */
    @XmlAttribute(name = "ValueLength")
    private Integer ValueLength;

    /**
     * 字段值类型「protobuf」
     */
    @XmlAttribute(name = "ValueType")
    private String ValueType;


    public Field() {
    }

    public Boolean getBeAnalyzed() {
        return BeAnalyzed;
    }

    public void setBeAnalyzed(Boolean beAnalyzed) {
        BeAnalyzed = beAnalyzed;
    }

    public Boolean getBeMerge() {
        return BeMerge;
    }

    public void setBeMerge(Boolean beMerge) {
        BeMerge = beMerge;
    }

    public Boolean getBeMultiValue() {
        return BeMultiValue;
    }

    public void setBeMultiValue(Boolean beMultiValue) {
        BeMultiValue = beMultiValue;
    }

    public Boolean getBeNotNull() {
        return BeNotNull;
    }

    public void setBeNotNull(Boolean beNotNull) {
        BeNotNull = beNotNull;
    }

    public Boolean getBeQueried() {
        return BeQueried;
    }

    public void setBeQueried(Boolean beQueried) {
        BeQueried = beQueried;
    }

    public String getCHName() {
        return CHName;
    }

    public void setCHName(String CHName) {
        this.CHName = CHName;
    }

    public String getCodeSet() {
        return CodeSet;
    }

    public void setCodeSet(String codeSet) {
        CodeSet = codeSet;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getENName() {
        return ENName;
    }

    public void setENName(String ENName) {
        this.ENName = ENName;
    }

    public String getElementID() {
        return ElementID;
    }

    public void setElementID(String elementID) {
        ElementID = elementID;
    }

    public Integer getSeqNumber() {
        return SeqNumber;
    }

    public void setSeqNumber(Integer seqNumber) {
        SeqNumber = seqNumber;
    }

    public String getValueDefault() {
        return ValueDefault;
    }

    public void setValueDefault(String valueDefault) {
        ValueDefault = valueDefault;
    }

    public Integer getValueLength() {
        return ValueLength;
    }

    public void setValueLength(Integer valueLength) {
        ValueLength = valueLength;
    }

    public String getValueType() {
        return ValueType;
    }

    public void setValueType(String valueType) {
        ValueType = valueType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;
        Field field = (Field) o;
        return Objects.equals(BeAnalyzed, field.BeAnalyzed) &&
                Objects.equals(BeMerge, field.BeMerge) &&
                Objects.equals(BeMultiValue, field.BeMultiValue) &&
                Objects.equals(BeNotNull, field.BeNotNull) &&
                Objects.equals(BeQueried, field.BeQueried) &&
                Objects.equals(CHName, field.CHName) &&
                Objects.equals(CodeSet, field.CodeSet) &&
                Objects.equals(Description, field.Description) &&
                Objects.equals(ENName, field.ENName) &&
                Objects.equals(ElementID, field.ElementID) &&
                Objects.equals(SeqNumber, field.SeqNumber) &&
                Objects.equals(ValueDefault, field.ValueDefault) &&
                Objects.equals(ValueLength, field.ValueLength) &&
                Objects.equals(ValueType, field.ValueType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BeAnalyzed, BeMerge, BeMultiValue, BeNotNull, BeQueried, CHName, CodeSet, Description, ENName, ElementID, SeqNumber, ValueDefault, ValueLength, ValueType);
    }

    @Override
    public String toString() {
        return "Field{" +
                "BeAnalyzed=" + BeAnalyzed +
                ", BeMerge=" + BeMerge +
                ", BeMultiValue=" + BeMultiValue +
                ", BeNotNull=" + BeNotNull +
                ", BeQueried=" + BeQueried +
                ", CHName='" + CHName + '\'' +
                ", CodeSet='" + CodeSet + '\'' +
                ", Description='" + Description + '\'' +
                ", ENName='" + ENName + '\'' +
                ", ElementID='" + ElementID + '\'' +
                ", SeqNumber=" + SeqNumber +
                ", ValueDefault='" + ValueDefault + '\'' +
                ", ValueLength=" + ValueLength +
                ", ValueType='" + ValueType + '\'' +
                '}';
    }
}
