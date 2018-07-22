package com.cuiwei.effective;

import java.util.Objects;

/**
 *
 */
public class EqualAndHashCode implements Comparable<EqualAndHashCode> {
    private int value1;
    private int value2;
    private String strValue;
    private int hashCode;

    public EqualAndHashCode(int value1, int value2, String strValue) {
        this.value1 = value1;
        this.value2 = value2;
        this.strValue = strValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualAndHashCode that = (EqualAndHashCode) o;
        return value1 == that.value1 &&
                value2 == that.value2 &&
                Objects.equals(strValue, that.strValue);
    }

    public int hashCode2() {
        return Objects.hash(value1, value2, strValue);
    }

    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + value1;
            result = 31 * result + value2;
            result = 31 * result + strValue.hashCode();
            hashCode = result;
        }
        return result;
    }


    @Override
    public int compareTo(EqualAndHashCode o) {
        int valueDiff1 = this.value1 - o.value1;
        if (valueDiff1 != 0) return valueDiff1;

        return this.value2 - o.value2;
    }

    @Override
    public String toString() {
        return "EqualAndHashCode{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", strValue='" + strValue + '\'' +
                ", hashCode=" + hashCode +
                '}';
    }

    public static void main(String[] args) {
        EqualAndHashCode e1 = new EqualAndHashCode(2, 2, "TEST");
        EqualAndHashCode e2 = new EqualAndHashCode(1, 2, "TEST");
        System.out.println("两对象是否相等？ " + e1.equals(e2));
        System.out.println("e1 对象的hashcode= " + e1.hashCode());
        System.out.println("e2 对象的hashcode= " + e2.hashCode2());
        System.out.println(e1.toString());
        System.out.println("e1 与 e2 谁更大？" + (e1.compareTo(e2) >= 0 ? e1 : e2));
    }
}
