package com.jetpack.compose.news.domain.usecases

import androidx.paging.PagingData
import com.jetpack.compose.news.domain.repository.NewsRepository
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(source: List<String>): Flow<PagingData<Article>>
    {
        return newsRepository.getNews(source)
    }
}