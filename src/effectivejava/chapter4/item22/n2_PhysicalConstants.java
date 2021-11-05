package effectivejava.chapter4.item22;

// Constant utility class (Page 108)
// 应该使用 不可实例化的工具类 导出常量
public class n2_PhysicalConstants {
    private n2_PhysicalConstants() {
    }  // Prevents instantiation

    // Avogadro's number (1/mol)
    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;

    // Boltzmann constant (J/K)
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;

    // Mass of the electron (kg)
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}
