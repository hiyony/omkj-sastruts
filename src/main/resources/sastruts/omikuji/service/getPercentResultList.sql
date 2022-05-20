SELECT DISTINCT f.unseicode, f.unseiname, r.cnt, r.per
  FROM (SELECT u.birthday, f.unseiname AS usname, COUNT(f.unseiname) AS cnt, 
  			   ROUND((100 * COUNT(f.unseiname) / SUM(COUNT(f.unseiname)) OVER()::numeric), 2) AS per
  		  FROM omikujii o
		 RIGHT OUTER JOIN fortunemaster AS f ON o.unseicode = f.unseicode
		 RIGHT OUTER JOIN unseiresult AS u ON o.omikujicode = u.omikujicode
		 WHERE birthday = ?
		 GROUP BY u.birthday, f.unseiname, f.unseicode) AS r
 RIGHT OUTER JOIN fortunemaster f ON f.unseiname = r.usname
 ORDER BY f.unseicode ASC;