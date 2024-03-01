package com.hsss.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsss.dbconnection.DbConnection;
import com.hsss.model.ProductDetails;

public class HandLoomService {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public int insertToCart(int userId, int productId) {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into carddetails(loginId,productId) values(?,?)");
			ps.setInt(1, userId);
			ps.setInt(2, productId);

			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<ProductDetails> getCardDetails(int loginId) {
		List<ProductDetails> details = new ArrayList<ProductDetails>();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"select * from hsss.productdetails pd, hsss.carddetails cd where cd.productId = pd.productId and cd.loginId ='"
							+ loginId + "'");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductDetails model = new ProductDetails();
				model.setAvailability(rs.getString("availability"));
				model.setCardId(rs.getInt("cardId"));
				model.setLoginId(rs.getInt("loginId"));
				model.setProductId(rs.getInt("productId"));
				model.setProductName(rs.getString("productName"));
				model.setRating(rs.getInt("rating"));
				model.setPrice(rs.getInt("price"));

				details.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}
}
