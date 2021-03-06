package ru.smak.math.fractals

import ru.smak.math.Complex
import kotlin.math.abs
import kotlin.math.max

/**
 * Класс множества Мандельброта
 */
class Mandelbrot {

    /**
     * r^2 для проверки принадлежности точки множеству
     */
    private var r2: Double = 4.0  // создаём контранту для проверки большести z^2

    /**
     * Количество итераций, в течение которых проверяется
     * принадлежность точки множеству
     */
    var maxIters = 200
    set(value) {
        //Проверяем устанавливаемое значение на корректность
        field = max(200, abs(value))
    }

    /**
     * Метод определения принадлежности точки множеству Мандельброта
     * @param c точка комплексной плоскости
     * @return true, если точка принадлежит множеству (при заданном значении maxIter)
     * false - в противном случае
     */
    fun isInSet(c: Complex): Float {
        //var z = Complex()
        val z = Complex()  // создали z  // val z теперь константа
        for (i in 1..maxIters){
            z powAssign 2  // pow - возведение в степень, создали новый метод powAssign - возведение в степень с присвоением.
                           // Это для того, чтобы не создавались новые объекты
            z += c
            //z = (z pow 2) + c
            //if (z.abs() > 2.0) return false
            if (z.abs2() > r2) return i.toFloat()/maxIters.toFloat()  // роверим, что z^2 больше чем r2, то точка множеству не принадлежит
        }
        // return true
        return 1F
    }
}