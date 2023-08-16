package TextBlock;

public class Demo {
    public static void main(String[] args) {
        String text = """
                This is a text block.
                It can be used to display
                long text.
                """;
        System.out.println(text);

        String text2 = """
                <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
                </html>
                """;
        System.out.println(text2);

        //支持转义字符(虽然这是不必要的)
        String text3 = """
                12345\n67890
                """;
    }
}
