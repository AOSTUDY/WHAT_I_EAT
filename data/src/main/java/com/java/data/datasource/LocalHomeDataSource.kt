package com.java.data.datasource

import com.java.data.R
import com.java.data.model.LocalButtonData
import com.java.data.model.TripData

class LocalHomeDataSource : HomeDataSource {
    override fun getNewAndHotData(): List<LocalButtonData> = listOf(
        LocalButtonData("고속버스", R.drawable.ic_camera),
        LocalButtonData("풀빌라", R.drawable.ic_castle),
        LocalButtonData("물놀이특가", R.drawable.ic_rabbit),
        LocalButtonData("아이야놀자", R.drawable.ic_camera),
        LocalButtonData("호캉스패키지", R.drawable.ic_castle),
        LocalButtonData("맛집", R.drawable.ic_camera),
    )

    override fun getBenefitData(): List<LocalButtonData> = listOf(
        LocalButtonData("돈버는놀테크", R.drawable.ic_camera),
        LocalButtonData("코인뽑기머신", R.drawable.ic_castle),
        LocalButtonData("나만의쿠폰", R.drawable.ic_rabbit),
        LocalButtonData("카드할인", R.drawable.ic_camera),
        LocalButtonData("8월혜택모음", R.drawable.ic_castle),
        LocalButtonData("맛집", R.drawable.ic_rabbit),
        LocalButtonData("돈버는놀테크", R.drawable.ic_camera),
        LocalButtonData("코인뽑기머신", R.drawable.ic_castle),
        LocalButtonData("나만의쿠폰", R.drawable.ic_rabbit),
        LocalButtonData("카드할인", R.drawable.ic_camera),
        LocalButtonData("8월혜택모음", R.drawable.ic_castle)
    )

    override fun getGoTripData(): List<TripData> = listOf(
        TripData("제주도", "https://i.insider.com/58525b95dd0895b7548b4b08?width=700"),
        TripData("강원도", "https://cdn.pixabay.com/photo/2015/03/27/11/13/mountain-694653_960_720.jpg"),
        TripData("부산", "https://cdn.epnc.co.kr/news/photo/202001/93682_85075_3859.jpg"),
        TripData("경상북도", "http://img.hani.co.kr/imgdb/resize/2018/0606/152816115439_20180606.JPG")
    )
}
