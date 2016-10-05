package fgecctv.com.xiaodemo.entity;

import fgecctv.com.module.remote.HttpService;
import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/30 14
 */
public class SearchMovieEntity extends BaseCIBNEntity {
    private String searchMovie;
    private String pageNumber = "1";
    private String pageSize = "10";

    public SearchMovieEntity(Subscriber subscriber, String searchMovie, String pageNumber, String pageSize) {
        super(subscriber);
        this.searchMovie = searchMovie;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    @Override
    public Observable getObservable(HttpService method) {
        return method.getSearchMovie(TEMPLATEID,searchMovie,pageNumber,pageSize);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }
}
