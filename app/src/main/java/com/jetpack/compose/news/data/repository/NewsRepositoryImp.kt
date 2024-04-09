package com.jetpack.compose.news.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jetpack.compose.news.data.remote.NewsAPI
import com.jetpack.compose.news.data.remote.NewsPagingSource
import com.jetpack.compose.news.domain.repository.NewsRepository
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(private val newsAPI: NewsAPI) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsAPI, sources.joinToString(","))
            }
        ).flow
    }
}