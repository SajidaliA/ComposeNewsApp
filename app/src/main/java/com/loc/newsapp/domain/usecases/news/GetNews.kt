package com.loc.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews (private val repository: NewsRepository) {
    operator fun invoke(source: List<String>) : Flow<PagingData<Article>>{
        return repository.getNews(sources = source)
    }
}