import java.lang.Integer.parseInt

/**
 * hello kt
 *
 * @author zgq
 * @date 2021/3/31
 * @version v1.2.0
 **/
fun main() {
//    println("hello world")
// 直接new一个类调用其public方法
//    val listen = TestKt().listen("mazhua", "shepi")
//    println(listen)
//    test1(1, 2);
//    val test2 = test2(2, 3)
//    println(test2)
//    test3(1, 2, 2, 3, 4, 4)

    /*
    // lambda匿名函数
    val lambdaSum: (Int, Int) -> Int = { x, y ->
          x + y
      }
      println(lambdaSum(1, 2))
    */

    /*
    // 定义可变变量. var 变量名 : 变量类型 = 变量值
    var a: Int = 1;
    // 系统自动辨别变量c的类型为Int, d的类型为String
    var c = 2;
    var d = "1e23"
    a = 2;
    println(a)
    // 定义不可变变量. val 变量名 : 变量类型 = 变量值
    val b: Int = 1;
    // b = 3; 编辑报错
    println(b)
    */

    /*
        // $ 表示一个变量名或者变量值
        // $varName 表示变量值
        // ${varName.fun()} 表示变量的方法返回值:
        val a = 2;
        println("a is $a")
        println("a is ${TestKt().listen("1,", "2")}")
    */

//    println(objToType(12321)) // 0
//    println(objToType("12321")) // 12321
//    println(objToType("12321ad")) // 转换异常

//    area()
//    area2()

//    dataType()
//    charType()

//    arr()
//    maxVal()
//    whenVal()

//    foo()
//    foo2()

//    val tc = Test2("hello", 23)
//    tc.par2 = 2
//    println("par2:${tc.par2}")
//    tc.pro1 = "给pro1赋值"
//    println("pro1:${tc.pro1}")


//    tc.setInterFace(object : TestInterface {
//        override fun drink() {
//            println("在Test2中设置的匿名内部类的drink方法执行")
//        }
//    })

//    val student = Student("zgq", 18, "男", "神技大学")
//    println("student的属性：${student}")
//    student.eat()
//    printFoo(student)
//    println(student.foo())

//    val test3 = Test3(100)
//    println(test3.a)
//    test3.tif()
//    test3.fit()
//    test3.drink()
//    test3.expand(100)

    

}

fun Student.foo() = "Student的扩展函数"
fun Person.foo() = "Person的扩展函数"

fun printFoo(per: Person) {
    println(per.foo())
}

// 扩展函数，指定某个类，为其添加函数, 若扩展函数与成员函数名称一致时，调用时，优先调用成员函数
fun Test3.expand(a: Int) {
    println("Test3的扩展函数，参数：$a")
}

class Test3(override var a: Int) : TestInterface2, TestInterface {
    override fun tif() {
        println("实现接口2中方法")
    }

    // 2个接口都实现了相同名称的默认方法，那么，共同继承这个2接口的类必须重写该方法，或者重新指定使用哪一个方法或2个方法都执行
    override fun fit() {
        super<TestInterface2>.fit()
        super<TestInterface>.fit()
        println("重写2个接口fit方法")
    }

    override fun drink() {
        println("实现接口1中方法")
    }
}

interface TestInterface2 {
    var a: Int

    fun tif()

    fun fit() {
        println("这是一个接口2的默认方法")
    }
}

class Student(name: String, age: Int, sex: String, var school: String) : Person(name, age, sex) {

    fun foo() = "Student的成员函数"

    override fun toString(): String {
        return "$name, $age, $sex, $school"
    }

    override fun eat() {
        println("Student is eating")
    }
}

// open 表示该类可以被继承 或 该方法可以被子类重写
open class Person(var name: String, var age: Int, var sex: String) {
    open fun eat() {
        println("Person is eating")
    }
}


// 定义一个接口
interface TestInterface {
    fun drink()

    fun fit() {
        println("这是一个接口的默认方法")
    }
}

class Test2 constructor(pro1: String, par2: Int) {

    // 给类定义一个匿名内部类
    fun setInterFace(test: TestInterface) {
        test.drink()
    }

    var pro1: String = pro1
        get() = field.toUpperCase() + "up"
        set(value) {
            field = pro1 + value + "这是一个pro1的set方法"
        }

    var par2: Int = par2
        get() {
            field += 100
            return field
        }
        set(value) {
            field = par2 + value + 1
        }
}

fun foo2() {
    val ints = arrayOf(1, 2, 3)
    // return 结束for循环
    ints.forEach {
        if (it == 2) return@forEach
        println(it)
    }

    // return 结束foo2方法
    ints.forEach { value ->
        run {
            println(value)
            if (value == 1) {
                return
            }
        }
    }
    println("函数执行完毕！")
}

// break 只中断当前循环，添加@loop后，直接中断到当前loop@所在的for循环
fun foo() {
    var a = 10;
    while (a > 2) {
        loop@ for (i in 1..5) {
            for (j in 1..9) {
                if (j < 10) {
                    println("i:$i j:$j")
                    break@loop
                }
            }
        }
        a--
    }
}

// 相当于java中的switch,更灵活,一个条件一个条件执行，一旦完成条件则进入，执行完后，直接出when语句
fun whenVal() {
    val validNumbers = Array(11) { x -> x }
    var a: Int
    for (validNumber in validNumbers) {
        a = validNumber
        when (a) {
            1 ->
                println("1的值：$a")
            2 ->
                println("2的值：$a")
            3, 4, 5 ->
                println("3,4,5的值：$a")
            in 6..9 ->
                println("6..9的值：$a")
            in validNumbers ->
                println("非法的值：$a")
            else ->
                println("else入口")
        }
    }

    println(hasPre("123ILoveYou"))

    whenAndIf(90)
}

fun whenAndIf(i: Int) {
    when {
        i == 2 -> {
            println("i与2相等")
        }
        isEqual3(i) -> {
            println("i与3相等")
        }
        else -> {
            println("i无匹配值")
        }
    }
}

private fun isEqual3(i: Int): Boolean {
    return i == 3
}

fun hasPre(x: Any) = when (x) {
    is String -> {
        x.startsWith("aa")
    }
    is Int -> {
        "aa"
    }
    else ->
        false
}

fun maxVal() {
    val a = 1
    val b = 2
    val max = if (a > b) a else b
    println("max的值：$max")
}

fun arr() {
    val arr1 = arrayOf(1, 2, 3)
    println(arr1[0])

    val arr2 = Array(5) { x -> x + 1 }
    println(arr2[3])

//     trimMargin() 方法来删除多余的空白。 trimIndent()去除空格
    val text = """   aa
        ni hao, 
        ni shi?
        who are you? 
        are you ok?
    """.trimIndent()
    println(text)
}

fun charType() {
    val a = '2'
    if (a in '0'..'9') {
        println(a.toInt()) // 50
        println(a.toInt() - '0'.toInt()) // 2
    }
}

fun dataType() {
    // 输出结果与java中的Integer一致，自动拆装箱的地址，保持一致，
    // 在-128~127范围内都相等，在超过范围后，数据不存在常量池中，地址就不相等
    val d: Int = 127;
//    val d: Int = 128;


    val a: Long = 123L
    val b: Float = 12.3F
    val c: Double = 12.3

    // 装箱,产生了2个对象
    val a1: Int? = d;
    val a2: Int? = d;

    // 此处未装箱，a3为基础类型值
    val a3 = d
    println(d == a3)
    println(d === a3)

    println(d == a1)
    println(a1 === d)

    println(a1 == a2)
    println(a1 === a2)

    // 类型转换时，向下转型需要队形的to方法执行，不可以直接转换
    val e: Int = a.toInt()
    // 此处自动推算了f的类型为Long.
    val f = e + a
    println("+++++++++++++++++++++")
    println(d.shl(1)) // left 左移
    println(d.shr(1)) // right 右移
//    ushr(bits) – 无符号右移位 (Java’s >>>)
//    and(bits) – 与
//    or(bits) – 或
//    xor(bits) – 异或
//    inv() – 反向
}

fun area2() {
    for (i in 1..4 step 2) {
        print("$i ")
    }
    // 每2步输出一次 :1 3
    println("++++++++++++++++")

    for (i in 4 downTo 1 step 2) {
        print("$i ")
    }
    // 每2步输出一次 :4 2
    println("++++++++++++++++")

    // 使用 until 函数排除结束元素 i in [1, 10) 排除了 10
    for (i in 1 until 10) {
        print("$i ")
    }
    println("++++++++++++++++")
}

fun area() {
    for (i in 1..4) {
        println(i)
    }
    // 1 2 3 4
    println("++++++++++++++++")
    for (i in 4..1) {
        println(i)
    }
    // 什么都不输出
    println("++++++++++++++++")
    for (i in 4 downTo 1) {
        println(i)
    }
    // 4 3 2 1
    println("++++++++++++++++")
    val i = 5
    // i 是否在 1-10区间内， 相当于 i >= 1 and i<= 10
    if (i in 10 downTo 1) {
        println("is true")
    } else {
        println("is false")
    }
    // 输出 is true
    println("++++++++++++++++")

}

// 在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，
// 另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
// 使用一个返回值可为 null 的函数
fun objToType(a: Any): Int? {
    if (a is String && a.length > 0) {
        return parseInt(a)
    }

    if (a !is String) {
        return 0
    }
    // 若返回值不加 ？ 则 return null 编辑异常
    return null
}

// 定义类, public 方法 修饰词默认隐藏
class TestKt {
    fun listen(arg1: String, arg2: String): Boolean {
        println("参数1：$arg1")
        println("参数2：$arg2")
        return arg1 == arg2
    }
}

// 无返回值函数
fun test1(a: Int, b: Int) {
    println(a + b)
}

// 返回函数，多参数
fun test2(a: Int, b: Int, c: Double, d: String): Int {
    println(c)
    println(d)
    return a + b
}

// 定义可变参数函数，参数可以直接以数组的形式传递
fun test3(vararg a: Int) {
    for (i in a) {
        print(i)
    }
}


