package com.example.recipefinder.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipefinder.ui.theme.AppColors

@Composable
fun RecipeCard(
    title: String,
    image: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // IMAGE
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            // TEXT SECTION
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = AppColors.PrimaryText,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "9 mins",
                        style = MaterialTheme.typography.labelSmall,
                        color = AppColors.SecondaryText
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "•",
                        color = AppColors.SecondaryText
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "⭐ 4.3",
                        style = MaterialTheme.typography.labelSmall,
                        color = AppColors.RatingGold,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // RIGHT ARROW
            Text(
                text = "›",
                color = AppColors.SecondaryText,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}