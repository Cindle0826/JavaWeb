-- 價格一律加 10%
UPDATE Book set price = price * 1.1 ;

-- 價格一律 1元
UPDATE book set price = 1;

-- 修改 id=1 的資料 name=Java8 price= 200
UPDATE Book set name = 'Java8' , price =200 where id = 4;
UPDATE Book set name = 'Python2' , price =250 where id = 3;