//接口
interface InputDevice { fun input(event: Any) }
//继承接口的接口
interface USBInputDevice: InputDevice
//继承接口并且自己也有抽象函数的接口
interface BLUETOOTHInputDevice: InputDevice { fun DevicePower(power: Int) }
//继承多个接口 所有的抽象函数都要实现
class USBMouse(private val name:String): USBInputDevice, BLUETOOTHInputDevice {
    override fun DevicePower(power: Int) {
    }
    override fun input(event: Any) {
    }

    override fun toString(): String {
        return name
    }
}
class Computer {
    private fun addUSBDevice(USEDevice:USBInputDevice) {
        //$对象名调用的是toString方法 上面已经重写了此方法为对象名本身
        println("已连接USB设备: $USEDevice")
    }
    private fun addBLUETOOTHDevice(BLUETOOTH:BLUETOOTHInputDevice) {
        println("已连接蓝牙设备: $BLUETOOTH")
    }
    fun addInputDevice(InputDevice:Any) {
        when(InputDevice) {
            //is关键字在这里判断前者有没有实现后者接口
            is BLUETOOTHInputDevice -> {
                addBLUETOOTHDevice(InputDevice)
            }
            is USBInputDevice -> {
                addUSBDevice(InputDevice)
            }
            else -> {
                throw IllegalArgumentException("此类型的设别暂时不被支持")
            }
        }
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    val mouse = USBMouse("microsoft")
    computer.addInputDevice(mouse)
}
//先判断device类型, 根据类型调用对应的inputDevice的方法