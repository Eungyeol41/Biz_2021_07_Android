package com.ini.nav

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView

class CurvedBottomNavigationView : BottomNavigationView {

    private var mPath: Path = Path()
    private var mPaint: Paint = Paint()

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        mPath = Path()
        mPaint = Paint()
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE)
        mPaint.setColor(Color.WHITE)
        setBackgroundColor(Color.rgb(86, 144, 255))
    }


    private val CURVE_CIRCLE_RADIUS = 108

    private val mFirstCurveStartPoint = Point()
    private val mFirstCurveEndPoint = Point()
    private val mFirstCurveControlPoint1 = Point()
    private val mFirstCurveControlPoint2 = Point()

    private var mSecondCurveStartPoint = Point()
    private val mSecondCurveEndPoint = Point()
    private val mSecondCurveControlPoint1 = Point()
    private val mSecondCurveControlPoint2 = Point()
    private var mNavigationBarWidth: Int = 0
    private var mNavigationBarHeight: Int = 0

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mNavigationBarWidth = width // 1080
        mNavigationBarHeight = height // 154

        // 360, 154
        mFirstCurveStartPoint.set(mNavigationBarWidth / 3, mNavigationBarHeight)
        // 0, 77
        mFirstCurveEndPoint.set(0, mNavigationBarHeight / 2)
        /*
        mSecondCurveStartPoint = mFirstCurveEndPoint
        mSecondCurveEndPoint.set(mNavigationBarWidth / 10, 0)
        */

        mFirstCurveControlPoint1.set(
            60, 115
            /*
            // 360 -
            mFirstCurveStartPoint.x - CURVE_CIRCLE_RADIUS / 9,
            // 77
            mFirstCurveStartPoint.y
            */
        )

        mFirstCurveControlPoint2.set(

            111, 111
            /*
            mFirstCurveStartPoint.x - CURVE_CIRCLE_RADIUS / 3,
            mFirstCurveEndPoint.y
            */
        )

        /*
        mSecondCurveControlPoint1.set(
            mSecondCurveStartPoint.x + CURVE_CIRCLE_RADIUS / 3,
            mSecondCurveStartPoint.y
        )
        mSecondCurveControlPoint2.set(
            mSecondCurveStartPoint.x + CURVE_CIRCLE_RADIUS / 9,
            mSecondCurveEndPoint.y
        )
        */

        mPath.reset()
        mPath.moveTo(0F, 0F)
        mPath.lineTo(mFirstCurveStartPoint.x.toFloat(), mFirstCurveStartPoint.y.toFloat())

        mPath.cubicTo(
            mFirstCurveControlPoint1.x.toFloat(), mFirstCurveControlPoint1.y.toFloat(),
            mFirstCurveControlPoint2.x.toFloat(), mFirstCurveControlPoint2.y.toFloat(),
            mFirstCurveEndPoint.x.toFloat(), mFirstCurveEndPoint.y.toFloat()
        )

        mPath.cubicTo(
            mSecondCurveControlPoint1.x.toFloat(), mSecondCurveControlPoint1.y.toFloat(),
            mSecondCurveControlPoint2.x.toFloat(), mSecondCurveControlPoint2.y.toFloat(),
            mSecondCurveEndPoint.x.toFloat(), mSecondCurveEndPoint.y.toFloat()
        )

        mPath.lineTo(mNavigationBarWidth.toFloat(), 0F)
        mPath.lineTo(mNavigationBarWidth.toFloat(), mNavigationBarHeight.toFloat())
        mPath.lineTo(0F, mNavigationBarHeight.toFloat())
        mPath.close()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(mPath, mPaint)
    }
}
