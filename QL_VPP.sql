create database QL_VPP
go
use QL_VPP
go


----Tao Bang Nhan vien

create table NhanVien
(
	MaNV varchar(10),
	HoTenNV nvarchar(100),
	GioiTinhNV nvarchar(10),
	SDT_NV varchar(10),
	SoCCCD varchar(12),
	NgaySinh date,
	DiaChiNV nvarchar(max),
	QueQuan nvarchar(100),
	HinhAnh nvarchar(max),
	constraint pk_NV_MaNV primary key (MaNV)
)

--Truy van, sua, xoa Bang Nhan Vien

drop table NhanVien

select * from NhanVien

select MaNV,HoTenNV,GioiTinhNV,SDT_NV,SoCCCD,format(NgaySinh,'dd/MM/yyyy') as NgaySinh,DiaChiNV,QueQuan from NhanVien

select HinhAnh from NhanVien where MaNV = 'NV005'

delete from NhanVien where MaNV = ''

select count(SDT_NV) from NhanVien where SDT_NV = '0241093441'

set dateformat dmy
update NhanVien
set HoTenNV = N'', GioiTinhNV = N'', SDT_NV = '', SoCCCD='', NgaySinh='', DiaChiNV = N'', QueQuan = N'', HinhAnh = N''
where MaNV = ''

--Insert Bang Nhan Vien

set dateformat dmy
insert into NhanVien(MaNV,HoTenNV,GioiTinhNV,SDT_NV,SoCCCD,NgaySinh,DiaChiNV,QueQuan)
values
('NV1',N'Nguyễn Đình Luân',N'Nam','0548293441','041746974641','12/2/1995',N'Hồ Chí Minh',N'Hà Nội'),
('NV2',N'Võ văn Phát',N'Nam','0241193441','033346974021','10/4/1998',N'Hồ Chí Minh',N'Bến Tre'),
('NV3',N'Nguyễn Ngọc Mi',N'Nữ','0458293221','052746974628','5/6/2000',N'Hồ Chí Minh',N'Hồ Chí Minh'),
('NV4',N'Trần Ngọc Hương',N'Nữ','0678293448','098746555641','6/8/2001',N'Hồ Chí Minh',N'Đà Lạt'),
('NV5',N'Cao Quốc Phú',N'Nam','0748297841','087746974233','11/7/1992',N'Hồ Chí Minh',N'Hà Nội')


----Tao Bang Khach Hang

create table KhachHang
(
	MaKH varchar(10),
	SoDTKH varchar(10),
	HoTenKH nvarchar(100),
	GioiTinhKH nvarchar(10),
	DiaChiKH nvarchar(max),
	EmailKH varchar(100),
	constraint pk_KH_MaKH primary key (MaKH)
)

--Truy van, sua, xoa Bang Nhan Vien

drop table KhachHang

select * from KhachHang

delete from KhachHang where MaKH = ''

set dateformat dmy
update KhachHang
set SoDTKH='', HoTenKH = N'', GioiTinhKH = N'', DiaChiKH = N'', EmailKH=''
where MaKH = ''

select * from KhachHang order by MaKH asc
select * from KhachHang order by MaKH desc

select * from KhachHang where SoDTKH like '%09%'

select * from KhachHang where GioiTinhKH like N'%nam%'

select count(MaKH) from KhachHang where SoDTKH = '0522554041'

select MaKH from KhachHang where SoDTKH = ''


--Insert Bang Khach Hang

insert into KhachHang(MaKH,SoDTKH,HoTenKH,GioiTinhKH,DiaChiKH,EmailKH) 
values 
('KH1','0929304043',N'Tô Quốc hải',N'Nam',N'744 Âu Cơ, Tân Thành, Tân Phú, Hồ Chí Minh',N'haivn@gmail.com'),
('KH2','0829306743',N'Như Lan Ngọc',N'Nữ',N'696 Lũy Bán Bích, Phú Thọ Họa, Tân Phú, Hồ Chí Minh',N'ngocxinhgai144@gmail.com'),
('KH3','0329304123',N'Nguyễn Tuấn Phát',N'Nam',N'725 Lũy Bán Bích, Tân Thành, Tân Phú, Hồ Chí Minh',N'namphatUvU@gmail.com'),
('KH4','0429304563',N'Trần Ngọc Minh',N'Nữ',N'828 Âu Cơ, Tân Thành, Tân Phú, Hồ Chí Minh',N'minhngonluHCM@gmail.com'),
('KH5','0522554043',N'Tony',N'Nam',null,N'tonystar@gmail.com')

----Tao Bang San Pham

create table SanPham
(
	MaSP varchar(10),
	TenSP nvarchar(max),
	SoLuong int default 0,
	DonViTinh nvarchar(50),
	GiaBan int,
	GiaNhap int,
	LoaiSP nvarchar(max),
	ThuongHieu nvarchar(max),
	HinhAnhSP nvarchar(max),
	constraint pk_SP_MaSP primary key (MaSP)
)

--Truy van, sua, xoa Bang San Pham

drop table SanPham

select * from SanPham

select MaSP,TenSP,SoLuong,DonViTinh,GiaBan,GiaNhap,LoaiSP,ThuongHieu from SanPham

select MaSP,TenSP,SoLuong,DonViTinh,GiaBan,HinhAnhSP from SanPham

delete from SanPham where MaSP = ''

update SanPham 
set TenSP=N'', SoLuong=, DonViTinh=N'', GiaBan=, GiaNhap=, LoaiSP=N'', ThuongHieu=N'', HinhAnhSP=N''
where MaSP = ''

select MaSP,TenSP,SoLuong,DonViTinh,GiaBan,GiaNhap,LoaiSP,ThuongHieu from SanPham order by SoLuong asc

select HinhAnhSP from SanPham where MaSP = 'SP009'


--Insert Bang San Pham

insert into SanPham(MaSP,TenSP,SoLuong,DonViTinh,GiaBan,GiaNhap,LoaiSP,ThuongHieu)
values
('SP1',N'Bút bi xanh Kim Long',550,N'Cái',1500,100,N'Bút Bi','Kim Long'),
('SP2',N'Bút bi đỏ Kim Long',350,N'Cái',1500,100,N'Bút Bi','Kim Long'),
----------------------Dụng cụ văn phòng -------------------------------------
('SP3',N'Kim bấm số 3',312,N'Hộp',2500,120,N'Kim bấm',N'Phát Tiến'),
('SP4',N'Bảng tên zipper dọc',300,N'Cái',5800,230,N'Bảng tên',N'Phát Tiến'),
('SP5',N'Dây đeo bảng tên',112,N'Dây',2800,120,N'Dây đeo',N'Phát Hòa'),
('SP6',N'Kẹp giấy tam giác',92,N'Cái',6400,175,N'Kẹp giấy',N'Toàn Phát'),
('SP7',N'Đồ bấm kim số 10',312,N'Cái',9500,110,N'Bấm kim',N'Hồng Hoa'),
----------------------Sổ - Tập - Bao Thư-------------------------------------
('SP8',N'Bao thư trắng A4',312,N'Cái',1000,120,N'Bao thư',N'Đại Nam'),
('SP9',N'Bao thư hồ sơ A4',180,N'Cái',2700,235,N'Bao thư',N'Đại Nam'),
('SP10',N'Sổ lò xo A5',122,N'Tập',16500,120,N'Sổ',N'Đại Nam'),
('SP11',N'Tập 96 trang ABC',92,N'Tập',7800,125,N'Tập',N'Toàn Phát'),
('SP12',N'Sổ lò xo A7 LAX',178,N'Hộp',9400,100,N'Sổ',N'Hồng Hoa'),
----------------------Bút - Mực-------------------------------------
('SP13',N'Bút bi Thiên Long',612,N'Hộp',2500,120,N'Bút',N'Thiên Long'),
('SP14',N'Bút chì 2B',200,N'Cái',1800,230,N'Bút',N'Thanh Trà'),
('SP15',N'Bút lông bảng Thiên Long',112,N'Cây',6000,130,N'Bút',N'Thiên Long'),
('SP16',N'Bút xóa nước Thiên Long',92,N'Cây',16500,179,N'Bút',N'Thiên Long'),
('SP17',N'Bút sơn toyo',312,N'Cây',17500,310,N'Bút',N'Thanh Trà'),
----------------------Giấy In Ấn - Photo-------------------------------------
('SP18',N'Giấy in BILL tính tiền',112,N'Cuộn',7500,190,N'Giấy In Ấn',N'Thanh Trà'),
('SP19',N'Giấy ghi chú',70,N'Cuộn',4600,230,N'Giấy In Ấn',N'Phát Tiến'),
('SP20',N'Decal in Nhiệt A7',82,N'Cuộn',36800,110,N'Giấy In Ấn',N'Tú Tài'),
('SP21',N'Decal A4 đế xanh giấy nhám',92,N'Tờ',58400,145,N'Giấy In Ấn',N'Tú Tài'),
('SP22',N'Giấy phân trang mũi tên 5 màu',142,N'Hộp',9500,130,N'Giấy In Ấn',N'Tú Tài'),
----------------------Bìa - Kệ - Rổ-------------------------------------
('SP23',N'Bìa lá A4',312,N'Cái',1600,300,N'Bìa',N'Long Thành'),
('SP24',N'Bìa nút A4',100,N'Cái',2500,230,N'Bìa',N'Long Thành'),
('SP25',N'Rổ nhựa xéo 1 ngăn',412,N'Rổ',2800,120,N'Rổ',N'Long Thành'),
('SP26',N'Bìa phân trang giấy',92,N'Cái',23400,575,N'Bìa',N'Huỳnh Hồng'),
('SP27',N'Bìa accor nhựa',212,N'Hộp',9100,310,N'Bìa',N'Huỳnh Hồng')


----Tao Bang Tai Khoan

create table TaiKhoan
(
	TenTK varchar(50),
	MatKhau varchar(100) default '123',
	MaNV varchar(10),
	Quyen nvarchar(30),
	constraint pk_TK_TenTK primary key(TenTK),
	constraint fk_TK_MaNV foreign key (MaNV) references NhanVien(MaNV)
)

--Truy van, sua, xoa Bang Tai Khoan

drop table TaiKhoan

update TaiKhoan set MatKhau = '' where TenTK = ''

select * from TaiKhoan

--Insert Bang Tai Khoan

insert into TaiKhoan(TenTK,MaNV,Quyen)
values
('NV1','NV1',N'Nhân viên kho'),
('NV2','NV2',N'Nhân viên thu ngân'),
('NV3','NV3',N'Quản lý'),
('NV4','NV4',N'Nhân viên thu ngân'),
('NV5','NV5',N'Nhân viên kho'),
('Admin',null,N'Admin')


create table TheTV
(
	MaThe varchar(10),
	MaKH varchar(10),
	TichDiem int default 0,
	NgayLapThe date default GETDATE(),
	constraint pk_TheTV_MaThe primary key(MaThe),
	constraint fk_TheTV_MaKH foreign key (MaKH) references KhachHang(MaKH)
)

select MaThe,MaKH,TichDiem,format(NgayLapThe,'dd/MM/yyyy') as NgayLapThe from TheTV

update TheTV set TichDiem = TichDiem + 1  where MaKH = 'KH1'

update TheTV set TichDiem =  - TichDiem  where MaKH = ''

insert into TheTV(MaThe,MaKH) values('T1','KH1')

select count(*) from TheTV where MaKH = 'KH1'

update TheTV set TichDiem = 11 where MaThe = 'T1'


create table HoaDon
(
	MaHD varchar(10),
	MaNV varchar(10),
	MaKH varchar(10),
	TongSL int default 0,
	TongTienHD int default 0,
	GiamGia int default 0,
	ThanhTien int default 0,
	TrangThai nvarchar(30) default N'Chưa thanh toán',
	LoaiGG nvarchar(20) default N'Đ',
	TGLap datetime,
	constraint pk_HD_MaHD primary key (MaHD),
	constraint fk_HD_MaNV foreign key (MaNV) references NhanVien(MaNV),
	constraint fk_HD_MaKH foreign key (MaKH) references KhachHang(MaKH)
)

insert into HoaDon(MaHD,MaNV,TrangThai) values('HD1','NV1',N'Đã thanh toán')
insert into HoaDon(MaHD,MaNV,MaKH) values('HD2','NV1','KH2')

select * from HoaDon



select MaHD,TongSL,TongTienHD,GiamGia,ThanhTien,TrangThai, 
format(TGLap,'dd/MM/yyyy, hh:mm:ss tt') as TGLap from HoaDon where MaHD = 'HD1'

select HoTenNV from HoaDon hd, NhanVien nv where hd.MaNV = nv.MaNV and MaHD = 'HD1'

select LoaiGG from HoaDon where MaHD = ''

select MaKH from HoaDon where MaHD = 'HD1'

select HoTenKH from HoaDon hd, KhachHang kh 
where hd.MaKH = kh.MaKH
and hd.MaHD = 'HD6' and hd.MaKH = 'KH1'

select MaNV from HoaDon where MaHD = 'HD1'

select TongSL from HoaDon where MaHD = 'HD1'

select TongTienHD from HoaDon where MaHD = 'HD1'

select GiamGia,LoaiGG from HoaDon where MaHD = 'HD1'

select ThanhTien from HoaDon where MaHD = 'HD1'

select TrangThai from HoaDon where MaHD = 'HD1'

delete HoaDon

drop table HoaDon


create table CTHD
(
	MaCTHD varchar(10),
	MaSP varchar(10),
	SoLuongSP int default 1,
	TongTien int default 0,
	constraint pk_CTHD_MaCTHD_MaSP primary key (MaCTHD,MaSP),
	constraint fk_CTHD_MaCTHD foreign key (MaCTHD) references HoaDon(MaHD),
	constraint fk_CTHD_MaSP foreign key (MaSP) references SanPham(MaSP)
)

update CTHD set SoLuongSP = SoLuongSP + 1 where MaCTHD = 'HD1' and MaSP = 'SP8'

select SoLuongSP+1 from CTHD where MaCTHD = 'HD1' and MaSP = 'SP8'

insert into CTHD(MaCTHD,MaSP,SoLuongSP)
values
('HD1','SP8',3),
('HD1','SP9',5),
('HD1','SP11',4)

select * from CTHD

select * from HoaDon

delete CTHD where MaCTHD = 'HD2'

delete HoaDon where MaHD = 'HD5'



select cthd.MaSP, TenSP ,SoLuongSP,TongTien 
from CTHD cthd, SanPham sp 
where cthd.MaSP = sp.MaSP and MaCTHD = 'HD2'
and TrangThai = N'Chưa thanh toán'

select top(1) MaHD from HoaDon where TrangThai = N'Chưa thanh toán'

select MaHD from HoaDon where TrangThai = N'Chưa thanh toán'

select MaHD,TongSL,TongTienHD,GiamGia,ThanhTien from HoaDon 


create table NhaCC
(
	MaNhaCC varchar(10),
	SoDTNCC varchar(10),
	HoTenNCC nvarchar(100),
	GioiTinhNCC nvarchar(10),
	DiaChiNCC nvarchar(max),
	SanPhamCC nvarchar(max),
	constraint pk_NhaCC_MaNhaCC primary key (MaNhaCC)
)

insert into NhaCC(MaNhaCC,SoDTNCC,HoTenNCC,GioiTinhNCC,DiaChiNCC,SanPhamCC) values
('NCC1','0921542102',N'Nguyễn Trường Hà',N'Nam',N'777 Lũy Bán Bích, Phú Thọ Hòa, Tân Phú, TP.HCM',N'Bút'),
('NCC2','0421122424',N'Cao Yến Ngọc',N'Nữ',N'262 Trương Vĩnh Ký, Phú Thọ Hòa, Tân Phú, TP.HCM',N'Giấy'),
('NCC3','0721332111',N'Trần Hải Nam',N'Nam',N'321 Âu Cơ, Tân Thành, Tân Phú, TP.HCM',N'Kim bấm, Bảng')

select * from NhaCC

select * from NhaCC where MaNhaCC like N'%NCC3%'

select count(MaNhaCC) from NhaCC where SoDTNCC = ''

create table DonDatHang
(
	MaDonDH varchar(10),
	MaNCC varchar(10),
	MaNV varchar(10),
	TongSLSPD int default 0,
	NgayDH date,
	TrangThaiDH nvarchar(30) default N'Chưa đặt',
	CapNhatTonKho nvarchar(30) default N'Chưa cập nhật'
	constraint pk_DonDatHang_MaDonDH primary key (MaDonDH),
	constraint fk_DonDatHang_MaNV foreign key (MaNV) references NhanVien(MaNV),
	constraint fk_DonDatHang_MaNCC foreign key (MaNCC) references NhaCC(MaNhaCC)
)

select MaDonDH,MaNCC,HoTenNV,TongSLSPD,format(NgayDH,'dd/MM/yyyy') as NgayDH,TrangThaiDH,CapNhatTonKho 
from DonDatHang ddh, NhanVien nv
where ddh.MaNV = nv.MaNV
order by MaDonDH desc


insert into DonDatHang(MaDonDH,MaNCC,MaNV) values('DDH1','NCC3','NV1')

update DonDatHang set NgayDH = GETDATE() where MaDonDH = 'DDH1'

update DonDatHang set CapNhatTonKho = N'Đã cập nhật' where MaDonDH = 'DDH1'

update DonDatHang set TrangThaiDH = N'Đã đặt' where MaDonDH = 'DDH1'

create proc CapNhatTongSLSPD @madondh varchar(10)
as
begin
	update DonDatHang 
	set TongSLSPD = (select sum(SoLuongSPD) from CTDonDatHang where MaDonDH =  @madondh) 
	where MaDonDH =  @madondh
end

exec CapNhatTongSLSPD 'DDH1'

create table CTDonDatHang
(
	MaDonDH varchar(10),
	MaSP varchar(10),
	SoLuongSPD int default 1,
	constraint pk_CTDonDatHang_MaDonDH_MaSP primary key (MaDonDH,MaSP),
	constraint fk_CTDonDatHang_MaDonDH foreign key (MaDonDH) references DonDatHang(MaDonDH),
	constraint fk_CTDonDatHang_MaSP foreign key (MaSP) references SanPham(MaSP)
)

select * from CTDonDatHang

select count(*) from CTDonDatHang where MaDonDH = 'DDH2'

UPDATE CTDonDatHang 
set SoLuongSPD = 3 
where  MaDonDH = 'DDH2'and MaSP = 'SP14'

select ctddh.MaSP,TenSP,SoLuongSPD 
from CTDonDatHang ctddh, SanPham sp 
where ctddh.MaSP = sp.MaSP and MaDonDH = ''

insert into CTDonDatHang(MaDonDH,MaSP,SoLuongSPD) values
('DDH1','SP3',1),
('DDH1','SP4',2),
('DDH1','SP7',3)

update CTDonDatHang set SoLuongSPD = where MaDonDH = '' and MaSP = ''

create proc CapNhatSLSP @masp varchar(10), @sl int
as
begin
	update SanPham
	set SoLuong = SoLuong - @sl
	where MaSP = @masp
end

create proc CapNhatSLSP_XoaHD @masp varchar(10), @sl int
as
begin
	update SanPham
	set SoLuong = SoLuong + @sl
	where MaSP = @masp
end

select MaSP from CTHD where MaCTHD = 'HD2'

select SoLuongSP from CTHD where MaCTHD = 'HD2' and MaSP = 'SP10'

select count(MaSP) from CTHD where MaCTHD = 'HD2'

select * from CTHD

select * from SanPham


exec CapNhatSLSP '',

exec CapNhatSLSP_XoaHD '',


create proc TongTien @macthd varchar(10), @masp varchar(10)
as
begin
	update CTHD
	set TongTien =  SoLuongSP*GiaBan 
	from CTHD cthd, SanPham sp 
	where cthd.MaSP = sp.MaSP and
	MaCTHD = @macthd and cthd.MaSP = @masp
end

exec TongTien 'HD1','SP9'

select sum(SoLuongSP) from CTHD where MaCTHD = 'HD1'

create proc TongSLSP @mahd varchar(10)
as
begin
	update HoaDon
	set TongSL = (select sum(CTHD.SoLuongSP) from CTHD where MaCTHD = @mahd)
	from HoaDon where MaHD = @mahd
end

exec TongSLSP 'HD1'

create proc TongTienHD @mahd varchar(10)
as
begin
	update HoaDon
	set TongTienHD = (select sum(CTHD.TongTien) from CTHD where MaCTHD = @mahd)
	from HoaDon where MaHD = @mahd
end

exec TongTienHD 'HD1'

create proc ThanhTien @mahd varchar(10)
as
begin
	update HoaDon 
	set ThanhTien = TongTienHD - GiamGia 
	where MaHD = @mahd
end

select count(*) from CTHD where MaCTHD =  ''

delete HoaDon where MaHD = 'HD2'

delete CTHD where MaCTHD = 'HD5'

select * from HoaDon

select SoLuongSP from CTHD where MaCTHD='HD4' and MaSP = 'SP16'

update HoaDon set GiamGia = 100, LoaiGG = N'Đ' where MaHD = 'HD2'

exec ThanhTien 'HD1'

update HoaDon set TGLap = CURRENT_TIMESTAMP where MaHD = 'HD1'


delete TaiKhoan


select * from TaiKhoan where MaNV is not null

update TaiKhoan 
set MatKhau='', MaNV='', Quyen=N''
where TenTK = ''

select count(*) from TaiKhoan where TenTK = 'NV3' and MatKhau = '123'

select distinct Quyen from TaiKhoan

select * from TaiKhoan where MaNV is not null order by TenTK desc

select * from TaiKhoan where MaNV is not null and TenTK like N'%02%'

