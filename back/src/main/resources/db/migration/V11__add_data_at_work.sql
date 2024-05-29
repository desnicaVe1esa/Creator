insert into work (publication_date, info)
values ('2024-05-29', 'Java. Разница между Stream.of(array) и Arrays.stream():\n
                       Stream.of() создает поток из фиксированного количества элементов, где каждый элемент является массивом. Это означает, что при использовании Stream.of(array) вы получите поток, содержащий один элемент - сам массив\n
                       Arrays.stream() же создает поток непосредственно из элементов массива. Он берет каждый элемент массива и помещает его в поток\n
                       Arrays.stream() обычно работает быстрее, чем Stream.of(), потому что он не создает дополнительный объект для хранения ссылки на массив')