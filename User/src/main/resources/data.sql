-- Dummy data for users table
-- Adjust table/column names if your @Table / @Column mappings differ
-- Written for PostgreSQL (UUID is native here); for MySQL, swap UUID for CHAR(36)

CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    phone_number INTEGER NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO users (id, phone_number, username, password, email) VALUES
  ('f9099e92-ce36-40dc-a69c-44960ba083f3', 446913428, 'karthik_pillai1', 'P@ss7155word', 'karthik.pillai0@example.com'),
  ('efb574cf-4ceb-4289-a1cc-b1f28e25e7fd', 749445767, 'pooja_sharma54', 'P@ss1395word', 'pooja.sharma1@example.com'),
  ('bbb64860-4fa6-4f11-8a07-670c0bbc98b2', 678119436, 'ananya_rao58', 'P@ss3239word', 'ananya.rao2@example.com'),
  ('70b226db-9189-4d9d-b45f-dddc525135a6', 774485118, 'suresh_reddy57', 'P@ss7632word', 'suresh.reddy3@example.com'),
  ('03ea6036-067c-4b58-8dd8-368c8c06b7e9', 909612869, 'vijay_kumar5', 'P@ss4445word', 'vijay.kumar4@example.com'),
  ('ea81fc64-1ff1-44a5-acd3-017ad6afdef5', 221951644, 'aditya_menon55', 'P@ss3980word', 'aditya.menon5@example.com'),
  ('2cf1554d-2f60-4c99-a612-11753ccfb8de', 882402872, 'meera_reddy32', 'P@ss7391word', 'meera.reddy6@example.com'),
  ('9ff77e34-0683-4e13-94a5-4f6cbd056708', 502618578, 'vikram_reddy25', 'P@ss5463word', 'vikram.reddy7@example.com'),
  ('d583c3fb-90b0-4140-b4d2-27ec614fae21', 792649779, 'pooja_reddy46', 'P@ss5749word', 'pooja.reddy8@example.com'),
  ('a1a38aaa-c2ae-484d-b2f7-360ca568972a', 582789452, 'priya_nair94', 'P@ss4031word', 'priya.nair9@example.com'),
  ('26bc5b1f-762f-48fa-bd19-bda42e065ce4', 921526369, 'sanjay_gupta95', 'P@ss3100word', 'sanjay.gupta10@example.com'),
  ('825007fa-9dbb-467c-b546-9dd0df6cf525', 452385791, 'vijay_pillai24', 'P@ss6284word', 'vijay.pillai11@example.com'),
  ('ac9bb2f0-7659-4bd3-a11f-ba1c86ab7967', 402235626, 'suresh_kumar67', 'P@ss9622word', 'suresh.kumar12@example.com'),
  ('e4e1b51a-20ee-4723-9321-ebbdec6cc9ab', 257879282, 'rohan_kumar27', 'P@ss7874word', 'rohan.kumar13@example.com'),
  ('1c1aeccf-b4bc-4af2-a624-d536fe177e7d', 358979728, 'sanjay_menon36', 'P@ss8175word', 'sanjay.menon14@example.com'),
  ('6d2b32b4-6111-4db2-b5f6-ac29e9455b7f', 553269818, 'ananya_reddy62', 'P@ss2168word', 'ananya.reddy15@example.com'),
  ('c260b6a5-2150-404c-89ac-9af53d294c1a', 780135793, 'rohan_sharma70', 'P@ss9604word', 'rohan.sharma16@example.com'),
  ('5bf6f079-ad61-4608-b79a-f01c81979de5', 172345398, 'lakshmi_kumar74', 'P@ss2276word', 'lakshmi.kumar17@example.com'),
  ('3add6184-b39f-45a9-b740-552751819fcc', 883803242, 'suresh_gupta12', 'P@ss8565word', 'suresh.gupta18@example.com'),
  ('ff5916e7-6005-4f35-a0c6-a799153d7b21', 811058226, 'pooja_kumar74', 'P@ss1300word', 'pooja.kumar19@example.com');