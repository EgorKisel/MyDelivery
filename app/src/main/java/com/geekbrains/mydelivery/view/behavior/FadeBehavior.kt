package com.geekbrains.mydelivery.view.behavior

import android.view.View
import android.widget.HorizontalScrollView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlin.math.abs

class FadeBehavior: CoordinatorLayout.Behavior<View>() {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is HorizontalScrollView
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        child.alpha = 1- abs(dependency.y*2/dependency.height.toFloat())
        return super.onDependentViewChanged(parent, child, dependency)
    }
}