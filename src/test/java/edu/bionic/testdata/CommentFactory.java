package edu.bionic.testdata;

import com.google.common.collect.Lists;
import edu.bionic.domain.Comment;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 * Created by alexandrrusanov on 9/8/17.
 */
public class CommentFactory {

//    INSERT INTO comments (product_id, author, datetime, text, rating)
//    VALUES (1, 'Сергей', '2016-12-28 13:00:00', 'Отличный девайс. Пользуюсь уже около года. Никаких замечаний', 5);
//    INSERT INTO comments (product_id, author, datetime, text, rating)
//    VALUES (4, 'Анна', '2017-03-12 15:00:00', 'Возникли проблемы на второй месяц использования. Пропадает зук в динамиках', 3);
//    INSERT INTO comments (product_id, author, datetime, text, rating)
//    VALUES (1, 'Инна', '2017-04-05 10:30:00', 'Хоший телефон. Единственный недостаток это цена :(', 4);

    public static Comment getComment1(){
        return new Comment(
                1,
                "Сергей",
                LocalDateTime.of(2016, Month.DECEMBER, 28, 13, 0),
                "Отличный девайс. Пользуюсь уже около года. Никаких замечаний",
                5
        );
    }

    public static Comment getComment2(){
        return new Comment(
                4,
                "Анна",
                LocalDateTime.of(2017, Month.MARCH, 12, 15, 0),
                "Возникли проблемы на второй месяц использования. Пропадает зук в динамиках",
                3
        );
    }

    public static Comment getComment3(){
        return new Comment(
                1,
                "Инна",
                LocalDateTime.of(2017, Month.APRIL, 05, 10, 30),
                "Хоший телефон. Единственный недостаток это цена :(",
                4
        );
    }

    public static List<Comment> getByProduct(){
        return Lists.newArrayList();
    }

    public static List<Comment> getAll(){
        return Lists.newArrayList(getComment1(), getComment2(), getComment3());
    }

    public static Comment getNewComment(){
        return new Comment(
                4,
                "Вася",
                LocalDateTime.of(2017, Month.MAY, 15, 18, 20),
                "Супер телефон",
                5
        );
    }
}
