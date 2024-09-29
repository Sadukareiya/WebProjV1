-- データベースが存在する場合は削除
--すでにtestdbのデータベースがある場合にそれを削除
drop database if exists testdb;

-- データベースの作成
create database testdb;

-- 使用するデータベースを指定
use testdb;

-- ユーザー情報を格納するテーブルの作成
create table users (
    user_id int primary key auto_increment,  -- 自動インクリメントのユーザーID
    user_name varchar(255),                  -- ユーザー名
    password varchar(255)                    -- パスワード
);
--auto_increment=自動的に１ずつ増加する設定

-- 初期データの挿入
insert into users values (1, "taro", "123");
insert into users values (2, "jiro", "456");
insert into users values (3, "hanako", "789");

-- 問い合わせ情報を格納するテーブルの作成
create table inquiry (
    name varchar(255),   -- 問い合わせ者の名前
    qtype varchar(255),  -- 問い合わせの種類
    body varchar(255)    -- 問い合わせ内容
);

--create teble inquiry=問い合わせ情報を格納するテーブルを作成
--name varchar=問い合わせを行った人の名前を格納するカラム
--qtype varchar=問い合わせの種類を格納するカラム
--body varchar=問い合わせの内容そのものを格納するカラム

--全体の流れ
--testdbという名前のデータベースを作成し、使用するデータベースとして指定
--userテーブルを作成し、ユーザー情報（ID/名前/パスワード）を格納
--初期データとして３つのユーザーをuserテーブルに挿入
--問い合わせの情報を格納するためのinquiryテーブルを作成

--このスクリプトはデータベースの基本構造を作成し、ユーザー情報や問い合わせ情報を管理する準備