package com.openinapp.ui.dashboard_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.openinapp.R
import com.openinapp.ui.theme.BlueRibbon
import com.openinapp.ui.theme.LocalCustomShapes
import com.openinapp.ui.theme.LocalSpacing
import com.openinapp.ui.theme.Manatee
import com.openinapp.utils.calculateSteps
import com.openinapp.utils.getDayNameFromDate
import com.openinapp.utils.getFormatDate


@Composable
fun Chart(values: Map<String, Int>) {
    if (values.isEmpty()) return
    val pointsData =
        values.entries.mapIndexed { index, entry -> Point(index.toFloat(), entry.value.toFloat()) }
    val min = values.entries.minBy { it.value }
    val max = values.entries.maxBy { it.value }
    val noOfSteps = 7
    val steps = calculateSteps(min.value, max.value, noOfSteps)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.medium)
            .background(color = Color.White, shape = LocalCustomShapes.current.smallShape)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = LocalSpacing.current.medium,
                    vertical = LocalSpacing.current.small
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Overview", color = Color.Gray)
            Row(
                modifier = Modifier
                    .padding(vertical = LocalSpacing.current.small)
                    .border(
                        width = .5.dp,
                        color = Color.Black,
                        shape = LocalCustomShapes.current.smallShape
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(LocalSpacing.current.small),
                    text = "${getFormatDate(values.entries.first().key)} - ${getFormatDate(values.entries.last().key)}",
                    style = MaterialTheme.typography.labelSmall
                )
                Icon(
                    modifier = Modifier.padding(horizontal = LocalSpacing.current.small),
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }

        val xAxisData = AxisData.Builder()
            .axisStepSize(100.dp)
            .steps(pointsData.size - 1)
            .labelData { i ->
                val e = values.entries.elementAt(i)
                getDayNameFromDate(e.key)
            }
            .labelAndAxisLinePadding(15.dp)
            .axisLabelColor(Color.BlueRibbon)
            .axisLineColor(Color.Manatee)
            .axisLabelFontSize(10.sp)
            .axisLineThickness(.6.dp)
            .build()

        val yAxisData = AxisData.Builder()
            .steps(noOfSteps)
            .labelAndAxisLinePadding(16.dp)
            .axisLabelColor(Color.BlueRibbon)
            .axisLineThickness(0.dp)
            .axisLabelFontSize(10.sp)
            .labelData { i ->
                if (i < noOfSteps) {
                    steps[i].toString()
                } else ""
            }.build()

        val lineChartData = LineChartData(
            linePlotData = LinePlotData(
                lines = listOf(
                    Line(
                        dataPoints = pointsData,
                        LineStyle(color = Color.BlueRibbon, width = 4F),
                        IntersectionPoint(color = Color.BlueRibbon, radius = 0.dp),
                        SelectionHighlightPoint(color = Color.BlueRibbon),
                        ShadowUnderLine(color = Color.BlueRibbon),
                        SelectionHighlightPopUp()
                    )
                ),
            ),
            xAxisData = xAxisData,
            yAxisData = yAxisData,
            gridLines = GridLines(color = Color.Gray.copy(alpha = .1F)),
            backgroundColor = Color.White
        )

        LineChart(modifier = Modifier.height(300.dp), lineChartData = lineChartData)
    }
}