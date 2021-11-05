package effectivejava.chapter4.item22;

// Constant interface antipattern - do not use!
// 接口应该只用于定义类型。它们不应该用于导出常量
public interface n1_PhysicalConstants {
    // Avogadro's number (1/mol)
    // 下划线自 Java 7 以来一直是合法的，它对数字字面值没有影响
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;

    // Boltzmann constant (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    // Mass of the electron (kg)
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}
