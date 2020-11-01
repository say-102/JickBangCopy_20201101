package kr.co.tjoeun.jickbangcopy_20201101.datas

import java.text.NumberFormat
import java.util.*

class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String) {

//    부가기능 직접 제작
//    1) price값에 따라서 가공된 가격 알려주기. (ex. 2억 8,500 or 3,600)

    fun getFormmatedPrice() : String {

//        price의 값이 1억(10000) 이상? 아닌가? 에 따라 다른 행동.

        if (price >= 10000) {

//            price : 25300, 175000 등 1만보다 큰 상태. 78500
//            결과 : 2억 5,300  , 17억 5,000 => ?억 + 나머지?

            val  uk = price / 10000 // 25300 / 10000 = 2.53(x) 2(o)   / <-소수점은 버림
            val rest = price % 10000 // 25300 % 10000 = 5300          % <-나누고 나머지

            val commaRest = NumberFormat.getNumberInstance(Locale.KOREA).format(rest)

            return "${uk}억 ${commaRest}"
        }
        else {

//            8500 등으로 1만이 안되는 경우만 여기서 실행.
//            컴마처리만 해서 바로 결과로 지정하자.

            return NumberFormat.getNumberInstance(Locale.KOREA).format(price)
        }
    }

//    2) 층수값에 따라서 몇층인지 알려주기. (ex. 2층, 반지하, 지하1층)

}