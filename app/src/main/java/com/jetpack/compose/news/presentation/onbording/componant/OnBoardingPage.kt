package com.jetpack.compose.news.presentation.onbording.componant

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.compose.news.R
import com.jetpack.compose.news.presentation.Dimens
import com.jetpack.compose.news.presentation.onbording.Page
import com.jetpack.compose.news.presentation.onbording.pages
import com.jetpack.compose.news.ui.theme.NewsTheme

@Composable
fun OnBoardingPage(
    page: Page,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Text(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )

        Text(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            text = page.description,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewOnBoardingPage() {
    NewsTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}