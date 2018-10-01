

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBProcessor {
    final static String url = "jdbc:mysql://localhost:3306/financedata";
    final static String userName = "root";
    final static String password = "root";



        public static void updatePriceChanges (List<String> names, List<String> absChange, List<String> relChange) {

            try {
                Connection connection = DriverManager.getConnection(url, userName, password);
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pricechange (index_number, index_name, abs_change, rel_change)\n" +
                        "VALUES (?, ?, ?, ?);");
                System.out.println(names.size());
                for(int i = 0; i < names.size(); i++) {
                    preparedStatement.setInt(1, i+1);
                    preparedStatement.setString(2, names.get(i));
                    preparedStatement.setString(3, absChange.get(i));
                    preparedStatement.setString(4, relChange.get(i));
                    preparedStatement.addBatch();
                }
                    preparedStatement.executeBatch();
                preparedStatement.close();
                connection.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    public static void updateIndexesValues (HashMap<Integer, List<String>> indexesValues) {

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO indexvalue (index_number, open_price, high_price, low_price)\n" +
                    "VALUES (?, ?, ?, ?);");
            for(int i = 0; i < indexesValues.size(); i++) {
                preparedStatement.setInt(1, i+1);
                preparedStatement.setString(2, indexesValues.get(i).get(0));
                preparedStatement.setString(3, indexesValues.get(i).get(1));
                preparedStatement.setString(4, indexesValues.get(i).get(2));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<IndexModel> selectIndexes () {

 List<IndexModel> indexes = new ArrayList<>();
 IndexModel indexModel;
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT index_name, rel_change FROM pricechange;");
            while(resultSet.next()){
                indexModel = new IndexModel();
                indexModel.setIndexName(resultSet.getString(1));
                indexModel.setIndexPriceChange(resultSet.getString(2));
                indexes.add(indexModel);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return indexes;
    }


}
