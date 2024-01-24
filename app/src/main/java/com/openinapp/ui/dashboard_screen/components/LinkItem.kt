package com.openinapp.ui.dashboard_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.openinapp.R
import com.openinapp.domain.models.Link
import com.openinapp.ui.theme.BlueRibbon
import com.openinapp.ui.theme.LocalCustomShapes
import com.openinapp.ui.theme.LocalSpacing
import com.openinapp.ui.theme.Manatee
import com.openinapp.utils.copyToClipboard
import com.openinapp.utils.dashedBorder
import com.openinapp.utils.getFormatDate
import com.openinapp.utils.showToast

@Composable
fun LinkItem(link: Link) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.medium,
                vertical = LocalSpacing.current.small
            )
            .background(color = Color.White, shape = LocalCustomShapes.current.smallShape)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalSpacing.current.small),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.fillMaxWidth(.65F)) {
                Icon(
                    modifier = Modifier.padding(LocalSpacing.current.extraSmall),
                    painter = painterResource(id = R.drawable.ic_amazon),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

                Column(modifier = Modifier.padding(LocalSpacing.current.extraSmall)) {
                    Text(
                        text = link.title ?: "Sample Link",
                        style = MaterialTheme.typography.labelMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = getFormatDate(
                            link.createdAt ?: "2023-03-15T07:33:50.000Z",
                            format = "dd MMM yyyy"
                        ),
                        style = MaterialTheme.typography.labelSmall.copy(color = Color.Manatee),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LocalSpacing.current.small),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${link.totalClicks ?: 0}",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "clicks",
                    style = MaterialTheme.typography.labelSmall.copy(color = Color.Manatee),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        LinkText(link = link.webLink ?: "www.openinapp.com")
    }
}

@Composable
fun LinkText(link: String) {
    val shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.BlueRibbon.copy(alpha = .1F), shape = shape)
            .dashedBorder(
                width = .6.dp,
                color = Color.BlueRibbon,
                shape = shape,
                on = 2.dp,
                off = 2.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(.65F)
                .padding(LocalSpacing.current.medium),
            text = link,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Icon(
            modifier = Modifier
                .padding(LocalSpacing.current.medium)
                .clickable {
                    copyToClipboard(link, context)
                    context.showToast("copied to clipboard!")
                },
            painter = painterResource(id = R.drawable.ic_copy),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}