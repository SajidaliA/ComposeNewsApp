package com.loc.newsapp.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source
import com.loc.newsapp.presentation.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.Dimens.SmallIconSize
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = Modifier.clickable { onClick() }) {
        //COIL image loading lib
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = article.source.name,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.body)
            )
            Spacer(modifier = Modifier.padding(ExtraSmallPadding2))
            Icon(
                painter = painterResource(id = R.drawable.ic_time),
                contentDescription = null,
                modifier = Modifier.size(SmallIconSize),
                tint = colorResource(id = R.color.body)
            )
            Spacer(modifier = Modifier.padding(ExtraSmallPadding2))
            Text(
                text = article.publishedAt,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.body)
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardPreview() {
    NewsAppTheme {
        ArticleCard(
            article = Article(
                author = "Test author",
                content = "This is test content of the news",
                description = "This is the test description",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "This is the test title to show in te test article",
                url = "",
                urlToImage = ""
            )
        ) {

        }
    }
}