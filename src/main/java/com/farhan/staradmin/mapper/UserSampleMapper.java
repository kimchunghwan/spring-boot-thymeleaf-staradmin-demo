package com.farhan.staradmin.mapper;

import com.farhan.staradmin.model.UserSample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserSampleMapper {
    @Select("SELECT * FROM user_sample")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "familyName", column = "family_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "familyKanaName", column = "family_kana_name"),
            @Result(property = "firstKanaName", column = "first_kana_name"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "office", column = "office"),
            @Result(property = "tel", column = "tel"),
            @Result(property = "mail", column = "mail"),
            @Result(property = "isQuit", column = "is_quit"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    List<UserSample> selectAllUsers();

    @Select("SELECT * FROM user_sample WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "familyName", column = "family_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "familyKanaName", column = "family_kana_name"),
            @Result(property = "firstKanaName", column = "first_kana_name"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "office", column = "office"),
            @Result(property = "tel", column = "tel"),
            @Result(property = "mail", column = "mail"),
            @Result(property = "isQuit", column = "is_quit"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    UserSample selectOneUserById(Long id);

    @Update("UPDATE user_sample SET "
            + "family_name = #{familyName}, "
            + "first_name = #{firstName}, "
            + "family_kana_name = #{familyKanaName}, "
            + "first_kana_name = #{firstKanaName}, "
            + "birthday = #{birthday}, "
            + "gender = #{gender}, "
            + "office = #{office}, "
            + "tel = #{tel}, "
            + "mail = #{mail}, "
            + "is_quit = #{isQuit}, "
            + "updated_at = #{updatedAt} "
            + "WHERE id = #{id}")
    void updateUser(UserSample userSample);

    @Update("UPDATE user_sample SET "
            + "is_quit = 1 "
            + "WHERE id = #{id}")
    void quitUserById(Long id);

    @Insert("INSERT INTO user_sample (family_name, first_name, family_kana_name, first_kana_name, birthday, gender, office, tel, mail, is_quit, created_at, updated_at) VALUES "
            + "(#{familyName}, "
            + "#{firstName}, "
            + "#{familyKanaName}, "
            + "#{firstKanaName}, "
            + "#{birthday}, "
            + "#{gender}, "
            + "#{office}, "
            + "#{tel}, "
            + "#{mail}, "
            + "false, "
            + "#{createdAt}, "
            + "#{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createUser(UserSample userSample);
}

/*
<select id="selectAll" resultType="com.iinexus.main.model.SearchEntity">
        select
        u.id,
        u.first_name,
        u.family_name,
        u.first_kana_name,
        u.family_kana_name,
        u.mail,
        po.id as order_id,
        po.total_price,
        po.order_date,
        po.created_at,
        po.updated_at
        FROM pre_order AS po
        LEFT JOIN user u on po.user_id = u.id
        WHERE 1 = 1
<if test="userId != null">
        AND u.id = #{userId}
</if>
<if test="mail != null and mail != ''">
        AND u.mail LIKE '${mail}%'
</if>
<if test="name !=null and name !=''">
        AND CONCAT(u.family_name, u.first_name) LIKE '${name}%'
</if>
<if test="kanaName !=null and kanaName !=''">
        AND CONCAT(u.family_kana_name, u.first_kana_name) LIKE '${kanaName}%'
</if>
<if test="from != null ">
<![CDATA[ AND po.order_date >= #{from} ]]>
</if>
<if test="to != null">
<![CDATA[ AND po.order_date <= #{to} ]]>
</if>
        ORDER BY po.order_date DESC
        LIMIT #{limit} OFFSET #{offset}
</select>
*/
